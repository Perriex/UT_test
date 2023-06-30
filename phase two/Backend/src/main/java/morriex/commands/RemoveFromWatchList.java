package morriex.commands;

import morriex.Entity.User;
import morriex.Model.urlParam.RemoveFromWatchListModel;
import morriex.context.ContextManager;

public class RemoveFromWatchList extends Command {
    public void handle(RemoveFromWatchListModel model) throws Exception {
        User user = ContextManager.getInstance().getUser(model.userEmail);
        user.removeFromWatch(model.movieId);
        ContextManager.getInstance().removeWatchlistItem(model.userEmail, model.movieId);
    }

    public void handleGet(RemoveFromWatchListModel model) throws Exception {
        handle(model);
    }
    
    public void handlePost(RemoveFromWatchListModel model) throws Exception {
        handle(model);
    }
}
