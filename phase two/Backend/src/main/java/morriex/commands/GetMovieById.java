package morriex.commands;

import morriex.Entity.Movie;
import morriex.Model.urlParam.GetMovieByIdModel;
import morriex.Model.view.MovieViewModel;
import morriex.context.ContextManager;

public class GetMovieById {

    public MovieViewModel handle(GetMovieByIdModel model) throws Exception{
        Movie movie = ContextManager.getInstance().getMovie(model.movieId);

        return movie.getModel();
    }
}
