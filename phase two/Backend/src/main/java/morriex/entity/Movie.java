package morriex.entity;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Column;

import morriex.model.ActorModel;
import morriex.model.MovieModel;
import morriex.model.UserModel;
import morriex.model.view.ActorShortModel;
import morriex.model.view.CommentViewModel;
import morriex.model.view.MovieShortModel;
import morriex.model.view.MovieViewModel;
import morriex.exception.CommentNotFound;

@Entity
public class Movie {
    @Id
    Integer movieId;
    String name;
    String summary;
    Date releaseDate;
    String director;
    Double imdbRate;
    Integer ageLimit;
    Integer duration;
    String image;
    String coverImage;

    @ElementCollection
    @CollectionTable(name = "MovieWritter", joinColumns = @JoinColumn(name = "MovieId"))
    @Column(name = "Name")
    Set<String> writers = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "MovieCast", joinColumns = @JoinColumn(name = "MovieId"))
    @Column(name = "ActorId")
    Set<Integer> cast = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "MovieGenre", joinColumns = @JoinColumn(name = "MovieId"))
    @Column(name = "Name")
    Set<String> genres = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "MovieRate", joinColumns = @JoinColumn(name = "MovieId"))
    @AttributeOverrides({
            @AttributeOverride(name = "userEmail", column = @Column(name = "UserEmail")),
            @AttributeOverride(name = "rate", column = @Column(name = "Rate"))
    })
    Set<Rating> ratings = new HashSet<>();

    @JoinColumn(name = "MovieId")
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    Set<Comment> comments = new HashSet<>();

    private Movie() {
    }

    public Movie(MovieModel model) {
        movieId = model.id;
        name = model.name;
        summary = model.summary;
        director = model.director;
        Collections.addAll(writers, model.writers);
        Collections.addAll(cast, model.cast);
        Collections.addAll(genres, model.genres);
        imdbRate = model.imdbRate;
        ageLimit = model.ageLimit;
        duration = model.duration;
        releaseDate = model.releaseDate;
        image = model.image;
        coverImage = model.coverImage;
    }

    public void addComment(Comment comment) {
        System.err.println(comment.commentId);
        System.err.println(comment.text);
        comments.add(comment);
    }

    public Comment getComment(Integer id) throws Exception {
        for (Comment comment : comments) {
            if (comment.commentId == id)
                return comment;
        }
        throw new CommentNotFound();
    }

    public Integer getAgeLimit() {
        return ageLimit;
    }

    public Boolean isInGenre(String targetGenre) {
        for (String genre : genres) {
            if (genre.equals(targetGenre)) {
                return true;
            }
        }
        return false;
    }

    public Boolean isReleaseDate(String date) {
        SimpleDateFormat formatNowYear = new SimpleDateFormat("YYYY-MM-dd");
        String year = formatNowYear.format(releaseDate);

        return year.equals(date);
    }

    public Boolean isActed(Integer actorId) {
        for (Integer actor : cast) {
            if (actor.equals(actorId)) {
                return true;
            }
        }
        return false;
    }

    public MovieViewModel getModel() throws Exception {
        MovieViewModel model = new MovieViewModel();
        model.movieId = movieId;
        model.name = name;
        model.summary = summary;
        model.director = director;
        model.writers = writers.toArray(new String[0]);
        model.genres = genres.toArray(new String[0]);
        model.imdbRate = imdbRate;
        model.rating = Double.parseDouble(String.format("%.01f", getRate()));
        model.ageLimit = ageLimit;
        model.duration = duration;
        model.releaseDate = releaseDate;
        model.image = image;
        model.coverImage = coverImage;
        model.cast = new ActorShortModel[cast.size()];
        model.comments = new CommentViewModel[comments.size()];
        int j = 0;
        for (Comment comment : comments) {
            model.comments[j++] = new CommentViewModel(comment, new User(new UserModel()));
        }
        j = 0;
        for (Integer actorI : cast) {
            model.cast[j++] =  new Actor(new ActorModel()).getShortModel();
        }

        return model;
    }

    public MovieShortModel getShortModel() throws Exception {
        MovieShortModel model = new MovieShortModel();
        model.movieId = movieId;
        model.name = name;
        model.director = director;
        model.rating = Double.parseDouble(String.format("%.01f", getRate()));
        model.ageLimit = ageLimit;
        model.duration = duration;
        model.writers = writers.toArray(new String[0]);
        model.genres = genres.toArray(new String[0]);
        model.releaseDate = releaseDate;
        model.imdbRate = imdbRate;
        model.summary = summary;
        model.image = image;
        model.coverImage = coverImage;

        model.cast = new ActorShortModel[cast.size()];

        Integer j = 0;
        for (Integer actorId : cast) {
            model.cast[j++] = new Actor(new ActorModel()).getShortModel();
        }

        return model;
    }

    public Double getRate() {
        if (ratings.size() == 0)
            return 0d;

        Double rateSum = 0d;

        for (Rating rating : ratings) {
            rateSum += rating.rate;
        }

        return rateSum / ratings.size();
    }

    public void addRate(String user, Integer rate) {
        // todo check duplicate
        ratings.add(new Rating(user, rate));
    }

    public Boolean isBetween(Date start, Date end) {
        return releaseDate.before(end) && releaseDate.after(start);
    }

    public Integer getNumberOfSameGenres(Movie movie) {
        Integer count = 0;
        for (String genre : genres) {
            if (movie.isInGenre(genre)) {
                count++;
            }
        }
        return count;
    }

    public Integer getId() {
        return movieId;
    }

    public String getName() {
        return name;
    }

    public Double getImdbRate() {
        return imdbRate;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    // todo
    // added sort
    public static Comparator<Movie> AcsendingDateComperator = new Comparator<Movie>() {

        public int compare(Movie m1, Movie m2) {
            Date r1 = m1.getReleaseDate();
            Date r2 = m2.getReleaseDate();

            return r2.compareTo(r1);
        }
    };
    public static Comparator<Movie> AcsendingIMDBRateComperator = new Comparator<Movie>() {

        public int compare(Movie m1, Movie m2) {
            Double r1 = m1.getImdbRate();
            Double r2 = m2.getImdbRate();

            // acsending
            return r2.compareTo(r1);
        }
    };
}
