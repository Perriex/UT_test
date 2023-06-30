package morriex.exception;

public class InvalidCommand extends HttpException {
    public InvalidCommand() {
        super();
        setStatus(403); // or 403?
    }

    public String getMessage() {
        return "InvalidCommand";
    }
}
