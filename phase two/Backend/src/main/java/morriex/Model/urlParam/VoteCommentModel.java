package morriex.Model.urlParam;

import morriex.validation.Email;
import morriex.validation.Nullable;

public class VoteCommentModel {
    @Email
    public String userEmail;
    public Integer commentId;
    @Nullable
    public Integer vote;

    public boolean isVoteCorrect() {
        return vote != null && (vote == 1 || vote == 0 || vote == -1);
    }
}
