package morriex.commands.console;

import morriex.Entity.Comment;
import morriex.Model.CommentModel;
import morriex.commands.Command;
import morriex.context.ContextManager;

public class AddComment extends Command {
    public String handle(CommentModel model) throws Exception {
        ContextManager.getInstance().getUser(model.userEmail);
        Comment comment = new Comment(model);
        ContextManager.getInstance().putComment(model.movieId, comment);
        return "comment with id " + comment.getCommentId() + " added successfully";
    }
}
