package morriex.service;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.models.Model;
import morriex.context.UserContext;

class Header {
    public String alg;
    public String typ;
}

class Payload {
    public String sub;
    public String iss;
    public Date exp;
}

public class JwtService {
    static String key = "iemdb1401";
    static String issuer = "abc23-abcse-2134-ydhfy2-1125";

    public static Boolean validateToken(String token) throws Exception {
        String[] parts = token.split("\\.");

        if (parts.length < 3)
            return false;

        if (!hmac(parts[0] + "." + parts[1], key).equals(parts[2]))
            return false;

        ObjectMapper objectMapper = new ObjectMapper();
        Payload payload = objectMapper.readValue(base64Decode(parts[1]), Payload.class);

        if (!payload.iss.equals(issuer))
            return false;

        if (payload.exp.compareTo(new Date()) < 0)
            return false;

        UserContext.email = payload.sub;
        return true;
    }

    public static String createToken(String userEmail) throws Exception {
        Header header = new Header();
        header.alg = "HS256";
        header.typ = "JWT";

        Payload payload = new Payload();
        payload.exp = getTomorrowDate();
        payload.iss = issuer;
        payload.sub = userEmail;

        ObjectMapper objectMapper = new ObjectMapper();
        String headerPart = base64Encode(objectMapper.writeValueAsString(header).getBytes("UTF-8"));
        String payloadPart = base64Encode(objectMapper.writeValueAsString(payload).getBytes("UTF-8"));
        String token = headerPart + "." + payloadPart;

        return token + "." + hmac(token, key);
    }

    private static String hmac(String data, String key)
            throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKeySpec);
        return base64Encode(mac.doFinal(data.getBytes()));
    }

    private static Date getTomorrowDate() {
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 1);
        dt = c.getTime();

        return dt;
    }

    private static String base64Encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    private static String base64Decode(String data) {
        return new String(Base64.getDecoder().decode(data));
    }
}
