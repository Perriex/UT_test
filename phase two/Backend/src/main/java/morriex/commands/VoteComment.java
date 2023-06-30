package morriex.commands;

import morriex.Entity.Comment;
import morriex.Model.urlParam.VoteCommentModel;
import morriex.context.ContextManager;
import morriex.exception.InvalidVoteValue;

public class VoteComment extends Command {
    public void handle(VoteCommentModel model) throws Exception {
        if (!model.isVoteCorrect()) {
            throw new InvalidVoteValue();
        }
        Comment comment = ContextManager.getInstance().getComment(model.commentId);
        ContextManager.getInstance().getUser(model.userEmail);
        comment.addVote(model.vote, model.userEmail);
        ContextManager.getInstance().putVote(model.userEmail, model);

    }

    public void handleGet(VoteCommentModel model) throws Exception {
        handle(model);
    }

    public void handlePost(VoteCommentModel model) throws Exception {
        handle(model);
    }
}
