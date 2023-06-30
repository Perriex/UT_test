package morriex.commands;

import java.util.ArrayList;
import java.util.Collection;

import morriex.entity.Movie;
import morriex.model.view.MovieListModel;
import morriex.context.ContextManager;

public class GetMovieList {

    public MovieListModel handle() throws Exception {
        Collection<Movie> movies = ContextManager.getInstance().getAllMovies();

        MovieListModel result = new MovieListModel();
        result.moviesList = new ArrayList<>();

        for (Movie movie : movies) {
            result.moviesList.add(movie.getShortModel());
        }
        return result;
    }
}
