package morriex.exception;

public class MovieNotFound extends HttpException {
    public MovieNotFound() {
        super();
        setStatus(404);
    }

    public String getMessage() {
        return "MovieNotFound";
    }
}
