package morriex.commands;

import java.util.ArrayList;
import java.util.Collection;

import morriex.entity.Movie;
import morriex.model.urlParam.GetMoviesBySearchModel;
import morriex.model.view.MovieListModel;
import morriex.context.ContextManager;

public class GetMoviesListBySearch {

    public MovieListModel handle(GetMoviesBySearchModel model) throws Exception {
        Collection<Movie> movies = ContextManager.getInstance().SearchMovieTitle(model.term);

        MovieListModel result = new MovieListModel();
        result.moviesList = new ArrayList<>();

        for (Movie movie : movies) {
            result.moviesList.add(movie.getShortModel());
        }

        return result;
    }
}
