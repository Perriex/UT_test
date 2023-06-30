package morriex.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import morriex.context.UserContext;

@RestController
public class LogoutController 
{
    @PostMapping("Logout")
    public ResponseEntity<String> LogOut() {
        UserContext.email = null;
        return ResponseEntity.ok("Successful Logout");
    }
}
