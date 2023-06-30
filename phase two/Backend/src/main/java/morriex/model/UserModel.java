package morriex.model;

import java.util.Date;

import morriex.validation.Email;

public class UserModel {
    @Email
    public String email;
    public String password;
    public String nickname;
    public String name;
    public Date birthDate;
}

