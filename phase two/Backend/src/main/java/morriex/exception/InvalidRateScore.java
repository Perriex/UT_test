package morriex.exception;

public class InvalidRateScore extends HttpException {
    public InvalidRateScore() {
        super();
        setStatus(403);
    }

    public String getMessage() {
        return "InvalidRateScore";
    }
}
