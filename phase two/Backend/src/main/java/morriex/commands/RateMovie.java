package morriex.commands;

import morriex.Entity.Movie;
import morriex.Model.urlParam.RateModel;
import morriex.context.ContextManager;
import morriex.exception.InvalidRateScore;

public class RateMovie extends Command {
    public String handle(RateModel model) throws Exception {
        if (model.score < 1 || model.score > 10) {
            throw new InvalidRateScore();
        }
        ContextManager.getInstance().getUser(model.userEmail);
        Movie movie = ContextManager.getInstance().getMovie(model.movieId);
        movie.addRate(model.userEmail, model.score);
        ContextManager.getInstance().putRateMovie(model.movieId, model);
        return "movie rated successfully";
    }

    public String handleGet(RateModel model) throws Exception {
        return handle(model);
    }

    public String handlePost(RateModel model) throws Exception {
        return handle(model);
    }
}
