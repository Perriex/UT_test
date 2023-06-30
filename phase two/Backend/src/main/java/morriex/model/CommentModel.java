package morriex.model;

import java.sql.Date;

import morriex.validation.Email;

public class CommentModel {
    @Email
    public String userEmail;
    public Integer movieId;
    public String text;
    public Date date;
}

