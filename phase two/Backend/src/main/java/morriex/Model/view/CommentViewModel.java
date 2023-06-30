package morriex.Model.view;

import morriex.Entity.Comment;
import morriex.Entity.User;
import morriex.Model.UserModel;

public class CommentViewModel implements Component {
    public Integer commentId;
    public UserModel user;
    public String text;
    public Integer like;
    public Integer dislike;

    public CommentViewModel(Comment comment, User _user) {
        super();
        commentId = comment.getCommentId();
        user = _user.getModel();
        text = comment.getText();
        like = comment.getLikes();
        dislike = comment.getDislikes();
    }

    @Override
    public String render() {
        return String.format(
                "<tr>" +
                        "<td>@%s</td><td>%s</td>" +
                        "<td>"+
                        "<label for=\"like\">%d</label>" +
                        "<button type=\"submit\" formaction=\"/voteComment/%d/1\"><i class=\"fa fa-thumbs-up\"></i></button></td></form>" +
                        "<td><form action=\"\" method=\"POST\"><label for=\"dislike\">%d</label>" +
                        "<button type=\"submit\" formaction=\"/voteComment/%d/-1\"><i class=\"fa fa-thumbs-down\"></i></button></td></td>" +
                        "</tr>",
                user.nickname, text, like, commentId, dislike, commentId);
    }
}