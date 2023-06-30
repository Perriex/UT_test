package morriex.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import morriex.entity.Movie;
import morriex.model.view.MovieListModel;
import morriex.context.ContextManager;

public class GetMovies {

    private Collection<Movie> search(String search, String searchBy) {
        
        if (search != null && searchBy != null) {
            switch (searchBy) {
                case "title":
                    return ContextManager.getInstance().SearchMovieTitle(search);
                case "genre":
                    return ContextManager.getInstance().getMoviesByGenre(search);
                case "releaseYear":
                    return ContextManager.getInstance().getMoviesWithDate(search);
            }
        }

        return ContextManager.getInstance().getAllMovies();
    }

    private Collection<Movie> sort(Collection<Movie> movies, String type) {

        if (type == null) {
            return movies;
        }

        ArrayList<Movie> list = new ArrayList<>(movies);
        switch (type) {
            case "date":
                Collections.sort(list, Movie.AcsendingDateComperator);
                break;
            default:
                Collections.sort(list, Movie.AcsendingIMDBRateComperator);
                break;
        }

        return list;
    }

    public MovieListModel handle(String search, String searchBy, String sortBy) throws Exception {
        Collection<Movie> movies = search(search, searchBy);
        movies = sort(movies, sortBy);

        MovieListModel result = new MovieListModel();
        result.moviesList = new ArrayList<>();

        for (Movie movie : movies) {
            result.moviesList.add(movie.getShortModel());
        }

        return result;
    }
}
