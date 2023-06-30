package morriex.Model.urlParam;

import morriex.validation.Email;

public class AddToWatchListModel {
    @Email
    public String userEmail;
    public Integer movieId;
}
