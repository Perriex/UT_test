package morriex.commands;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import morriex.Entity.Movie;
import morriex.Model.urlParam.SearchMovieByReleaseDateModel;
import morriex.Model.view.MovieListModel;
import morriex.context.ContextManager;

public class SearchMoviesByReleaseDate {

    public MovieListModel handle(SearchMovieByReleaseDateModel model) throws Exception {
        Calendar cld = Calendar.getInstance();
        cld.set(model.startYear, 1, 1);
        Date start = cld.getTime();
        cld.set(model.endYear, 1, 1);
        Date end = cld.getTime();
        Collection<Movie> movies = ContextManager.getInstance().getMoviedBetween(start, end);

        MovieListModel result = new MovieListModel();
        result.moviesList = new ArrayList<>();

        for (Movie movie : movies) {
            result.moviesList.add(movie.getShortModel());
        }

        return result;
    }
}
