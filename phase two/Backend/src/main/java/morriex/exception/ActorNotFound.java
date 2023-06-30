package morriex.exception;

public class ActorNotFound extends HttpException {
    public ActorNotFound() {
        super();
        setStatus(404);
    }

    public String getMessage() {
        return "ActorNotFound";
    }
}
