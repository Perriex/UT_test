package morriex.model.urlParam;

import morriex.validation.Email;

public class RateModel {
    @Email
    public String userEmail;
    public Integer movieId;
    public Integer score;
}
