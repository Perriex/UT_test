
package morriex.commands;

import java.util.ArrayList;
import java.util.Collection;

import morriex.Entity.Movie;
import morriex.Model.urlParam.SortMoviesModel;
import morriex.Model.view.MovieListModel;
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
