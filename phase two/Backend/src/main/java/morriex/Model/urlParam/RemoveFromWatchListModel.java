package morriex.Model.urlParam;

import morriex.validation.Email;

public class RemoveFromWatchListModel {
    @Email
    public String userEmail;
    public Integer movieId;
}