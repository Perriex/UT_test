package morriex.exception;

public class CommentNotFound extends HttpException {
    public CommentNotFound() {
        super();
        setStatus(404);
    }

    public String getMessage() {
        return "CommentNotFound";
    }
}
