package morriex.controllers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import morriex.entity.User;
import morriex.model.UserModel;
import morriex.model.urlParam.LoginModel;
import morriex.model.view.IdentityModel;
import morriex.context.ContextManager;
import morriex.context.UserContext;
import morriex.service.JwtService;

@JsonIgnoreProperties(ignoreUnknown = true)
class GithubUser {
    public String login;
    public String email;
    @JsonProperty("created_at")
    public Date createdAt;
    public String name;
}

@RestController
public class LoginController {
    private String ClientSecret = "0af612f950d0711839956e276fb86470ebe8ae80";
    private String ClientId = "b9793073f819f5ebaa4d";

    @GetMapping("Auth")
    public ResponseEntity<IdentityModel> Auth(String code) {
        String accessTokenString = String.format(
                "https://github.com/login/oauth/access_token?client_id=%s&client_secret=%s&code=%s", ClientId,
                ClientSecret, code);

        HttpClient client = HttpClient.newHttpClient();
        URI accessTokenUri = URI.create(accessTokenString);
        HttpRequest.Builder accessTokenBuilder = HttpRequest.newBuilder().uri(accessTokenUri);
        HttpRequest accessTokenRequest = accessTokenBuilder.POST(HttpRequest.BodyPublishers.noBody())
                .header("accept", "application/json").build();

        HttpResponse<String> accessTokenResult = null;
        try {
            accessTokenResult = client.send(accessTokenRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> resultBody = new HashMap<>();
        try {
            resultBody = mapper.readValue(accessTokenResult.body(), HashMap.class);
        } catch (JsonProcessingException e1) {
            e1.printStackTrace();
        }
        String accessToken = (String) resultBody.get("access_token");

        URI userDataUri = URI.create("https://api.github.com/user");
        HttpRequest.Builder userDataBuilder = HttpRequest.newBuilder().uri(userDataUri);
        HttpRequest req = userDataBuilder.GET().header("authorization", String.format("token %s", accessToken)).build();
        try {
            HttpResponse<String> userDataResult = client.send(req, HttpResponse.BodyHandlers.ofString());
            GithubUser user = mapper.readValue(userDataResult.body(), GithubUser.class);
            System.err.println(userDataResult.body());
            System.err.println(user.email);
            System.err.println(user.login);
            System.err.println(user.name);
            System.err.println(user.createdAt);
            UserModel model = new UserModel();
            model.name = user.name;
            model.email = user.email;
            model.nickname = user.login;

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(user.createdAt);
            calendar.add(Calendar.YEAR, -18);
            model.birthDate = calendar.getTime();

            IdentityModel response = new IdentityModel();
            response.email = user.email;
            response.token = JwtService.createToken(user.email);
            
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            e.printStackTrace();
        }

        
        return null;
    }

    @PostMapping("Login")
    public ResponseEntity<String> Login(@RequestBody LoginModel model) throws Exception {
        try {
            User user = ContextManager.getInstance().getUser(model.email);
            if(!user.checkPassword(model.password)){
                return new ResponseEntity<String>("1003", HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        UserContext.email = model.email;
        return ResponseEntity.ok(JwtService.createToken(model.email));
    }

    @PostMapping("Register")
    public ResponseEntity<String> Register(@RequestBody UserModel model) throws Exception {
        try {
            ContextManager.getInstance().getUser(model.email);
            return new ResponseEntity<String>("1001", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
        }

        try {
            User user = new User(model);
            user.hassPass();
            ContextManager.getInstance().putUser(model.email, user);
        } catch (Exception e2) {
            return new ResponseEntity<String>("1002", HttpStatus.BAD_REQUEST);
        }

        UserContext.email = model.email;
        return ResponseEntity.ok(JwtService.createToken(model.email));
    }
}
