package morriex.model.urlParam;

import morriex.validation.Email;

public class AddToWatchListModel {
    @Email
    public String userEmail;
    public Integer movieId;
}
