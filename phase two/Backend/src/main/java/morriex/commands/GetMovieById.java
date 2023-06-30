package morriex.commands;

import morriex.entity.Movie;
import morriex.model.urlParam.GetMovieByIdModel;
import morriex.model.view.MovieViewModel;
import morriex.context.ContextManager;

public class GetMovieById {

    public MovieViewModel handle(GetMovieByIdModel model) throws Exception{
        Movie movie = ContextManager.getInstance().getMovie(model.movieId);

        return movie.getModel();
    }
}
