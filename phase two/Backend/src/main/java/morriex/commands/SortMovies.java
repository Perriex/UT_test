
package morriex.commands;

import java.util.ArrayList;
import java.util.Collection;

import morriex.entity.Movie;
import morriex.model.urlParam.SortMoviesModel;
import morriex.model.view.MovieListModel;
import morriex.context.ContextManager;

public class SortMovies {

    public MovieListModel handle(SortMoviesModel model) throws Exception {
        Collection<Movie> movies = ContextManager.getInstance().Sort(model.type);

        MovieListModel result = new MovieListModel();
        result.moviesList = new ArrayList<>();

        for (Movie movie : movies) {
            result.moviesList.add(movie.getShortModel());
        }

        return result;
    }
}
