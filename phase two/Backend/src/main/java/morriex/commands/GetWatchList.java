package morriex.commands;

import java.util.ArrayList;

import morriex.entity.Movie;
import morriex.entity.User;
import morriex.model.urlParam.GetWatchListModel;
import morriex.model.view.WatchListModel;
import morriex.context.ContextManager;

public class GetWatchList extends Command {

    public WatchListModel handle(GetWatchListModel model) throws Exception{
        User user = ContextManager.getInstance().getUser(model.userEmail);
        ArrayList<Integer> watch = user.getWatch();
        
        WatchListModel returnModel = new WatchListModel();

        returnModel.watchList = new ArrayList<>();
        for (Integer integer : watch) {
            Movie movie = ContextManager.getInstance().getMovie(integer);
            returnModel.watchList.add(movie.getShortModel());
        }
        returnModel.recommendations = new ArrayList<>();

        for (Movie movie : ContextManager.getInstance().getRecommendations(model.userEmail)) {
            returnModel.recommendations.add(movie.getShortModel());
        }

        returnModel.user = user.getModel();
        return returnModel;
    }
}
