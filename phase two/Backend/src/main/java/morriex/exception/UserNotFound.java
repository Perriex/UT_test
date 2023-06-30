package morriex.exception;

public class UserNotFound extends HttpException {
    public UserNotFound() {
        super();
        setStatus(404);
    }

    public String getMessage() {
        return "UserNotFound";
    }
}
