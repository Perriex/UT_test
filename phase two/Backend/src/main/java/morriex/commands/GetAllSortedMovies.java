package morriex.commands;

import java.util.ArrayList;
import java.util.Collection;

import morriex.Entity.Movie;
import morriex.Model.view.MovieListModel;
import morriex.context.ContextManager;

public class GetAllSortedMovies {

    public MovieListModel handle(String search, String searchBy, String sortBy) throws Exception {
        Collection<Movie> movies = ContextManager.getInstance().getAllSortedMovies();

        MovieListModel result = new MovieListModel();
        result.moviesList = new ArrayList<>();

        for (Movie movie : movies) {
            result.moviesList.add(movie.getShortModel());
        }
        return result;
    }
}
