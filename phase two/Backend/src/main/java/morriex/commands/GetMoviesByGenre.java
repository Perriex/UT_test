package morriex.commands;

import java.util.ArrayList;
import java.util.Collection;

import morriex.Entity.Movie;
import morriex.Model.urlParam.GetMoviesByGenreModel;
import morriex.Model.view.MovieListModel;
import morriex.context.ContextManager;

public class GetMoviesByGenre {
    public MovieListModel handle(GetMoviesByGenreModel model) throws Exception {
        Collection<Movie> movies = ContextManager.getInstance().getMoviesByGenre(model.genre);

        MovieListModel result = new MovieListModel();
        result.moviesList = new ArrayList<>();

        for (Movie movie : movies) {
            result.moviesList.add(movie.getShortModel());
        }

        return result;
    }
}
