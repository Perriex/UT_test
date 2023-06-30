package morriex.exception;

public class AgeLimitError extends HttpException {
    public AgeLimitError() {
        super();
        setStatus(403);
    }

    public String getMessage() {
        return "AgeLimitError";
    }
}
