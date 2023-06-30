package morriex.exception;

public class InvalidVoteValue extends HttpException {
    public InvalidVoteValue() {
        super();
        setStatus(403);
    }

    public String getMessage() {
        return "InvalidVoteValue";
    }
}
