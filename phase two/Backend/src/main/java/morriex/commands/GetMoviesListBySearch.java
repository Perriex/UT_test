package morriex.commands;

import java.util.ArrayList;
import java.util.Collection;

import morriex.Entity.Movie;
import morriex.Model.urlParam.GetMoviesBySearchModel;
import morriex.Model.view.MovieListModel;
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
