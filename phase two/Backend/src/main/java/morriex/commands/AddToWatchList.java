package morriex.commands;

import morriex.entity.Movie;
import morriex.entity.User;
import morriex.model.urlParam.AddToWatchListModel;
import morriex.context.ContextManager;
import morriex.exception.AgeLimitError;

public class AddToWatchList extends Command {
    public void handle(AddToWatchListModel model) throws Exception {
        User user = ContextManager.getInstance().getUser(model.userEmail);
        Movie movie = ContextManager.getInstance().getMovie(model.movieId);
        if (movie.getAgeLimit() > user.getAge()) {
            throw new AgeLimitError();
        }
        user.addToWatch(model.movieId);
        ContextManager.getInstance(). putWatchlist(model.userEmail, model.movieId);
        return;
    }

    public void handleGet(AddToWatchListModel model) throws Exception {
        handle(model);
    }

    public void handlePost(AddToWatchListModel model) throws Exception {
        handle(model);
    }
}
