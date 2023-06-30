package morriex.commands;

import java.util.ArrayList;

import morriex.Entity.Movie;
import morriex.Entity.User;
import morriex.Model.urlParam.GetWatchListModel;
import morriex.Model.view.WatchListModel;
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
