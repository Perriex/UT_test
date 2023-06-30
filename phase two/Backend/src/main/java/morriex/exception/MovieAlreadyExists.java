package morriex.exception;

public class MovieAlreadyExists extends HttpException {
    public MovieAlreadyExists() {
        super();
        setStatus(403);
    }

    public String getMessage() {
        return "MovieAlreadyExists";
    }
}
