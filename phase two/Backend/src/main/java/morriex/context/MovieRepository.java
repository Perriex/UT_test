package morriex.context;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import morriex.entity.Movie;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {
    List<Movie> findByOrderByImdbRateAsc();
    List<Movie> findByOrderByReleaseDateAsc();
    List<Movie> findByGenres(String genre);
    List<Movie> findByReleaseDate(Date date);
    List<Movie> findByCast(Integer actorId);
    List<Movie> findByNameContains(String name);
    List<Movie> findByReleaseDateBetween(Date start, Date end);

    @Query(value = "SELECT * FROM Movie m LEFT JOIN WatchListItem w2 ON w2.movieId=m.movieId AND w2.userEmail=?1 WHERE w2.WatchListItemId IS NULL " +
        "ORDER BY m.imdbRate + (select avg(r.rate) " +
        "from MovieRate r WHERE movieId = m.movieId) + 3 * (select count(distinct g1.Name) from MovieGenre g1 " +
        "JOIN WatchListItem w ON w.movieId = g1.movieId JOIN movieGenre g2 ON g2.movieId = m.movieId AND g2.Name = g1.Name " +
        "WHERE w.userEmail=?1) " +
        "DESC LIMIT 3",
         nativeQuery = true)
    List<Movie> findRecommandationsByUser(String userEmail);
}
