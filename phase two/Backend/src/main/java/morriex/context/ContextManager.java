package morriex.context;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.commons.dbcp.BasicDataSource;

import morriex.entity.Actor;
import morriex.entity.Comment;
import morriex.entity.Movie;
import morriex.entity.User;
import morriex.model.ActorModel;
import morriex.model.CommentModel;
import morriex.model.MovieModel;
import morriex.model.UserModel;
import morriex.model.urlParam.RateModel;
import morriex.model.urlParam.VoteCommentModel;
import morriex.model.view.ActorViewModel;
import morriex.exception.ActorNotFound;
import morriex.exception.UserNotFound;
import morriex.service.Http;
import morriex.validation.IgnoreFailureTypeAdapterFactory;

import java.lang.Integer;
import java.lang.String;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class ContextManager {
    private static ContextManager instance;
    private static final BasicDataSource ds = new BasicDataSource();
    private final static String dbURL = "jdbc:mysql://iemdb-database:3306/IEMDB?allowMultiQueries=true";
    private final static String dbUserName = "morriex";
    private final static String dbPassword = "1qaz@WSX";
    public static MovieRepository movieRepository;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ds.setUsername(dbUserName);
        ds.setPassword(dbPassword);
        ds.setUrl(dbURL);
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
        setEncoding();
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void setEncoding() {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute("ALTER DATABASE IEMDB CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ContextManager getInstance() {
        if (instance == null) {
            instance = new ContextManager();
            try {
                instance.initialize();
            } catch (Exception ignored) {
                System.err.println(ignored.getMessage());
            }
        }
        return instance;
    }

    public void initialize() throws Exception {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy/MM/dd")
                .registerTypeAdapterFactory(new IgnoreFailureTypeAdapterFactory())
                .create();

        String actors = Http.Get("v2/actors");
        try {

            ActorModel[] actorsArray = gson.fromJson(actors, ActorModel[].class);
            for (ActorModel model : actorsArray) {
                Actor actor = new Actor(model);
                putActor(model.id, actor);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String users = Http.Get("users");
        UserModel[] usersArray = gson.fromJson(users, UserModel[].class);
        for (UserModel model : usersArray) {
            User user = new User(model);
            user.hassPass();
            putUser(model.email, user);
        }

        String movies = Http.Get("v2/movies");
        MovieModel[] moviesArray = gson.fromJson(movies, MovieModel[].class);
        for (MovieModel model : moviesArray) {
            Movie movie = new Movie(model);
            putMovie(model.id, movie);
        }

        String comments = Http.Get("comments");
        CommentModel[] commentsArray = gson.fromJson(comments, CommentModel[].class);
        for (CommentModel model : commentsArray) {
            Comment comment = new Comment(model);
            putComment(model.movieId, comment);
        }
    }

    public void putComment(Integer id, Comment comment) throws Exception {
        Connection con = getConnection();
        StringBuilder builder = new StringBuilder();

        builder.append("INSERT INTO `IEMDB`.`Comment`( \n");
        builder.append("`UserEmail`,`MovieId`,`Text`)");
        builder.append("VALUES");
        builder.append(String.format("(\"%s\", %d, \"%s\")",
                comment.getEmail(),
                comment.getMovieId(),
                comment.getText()));
        builder.append("ON DUPLICATE KEY UPDATE ");
        builder.append(
                "`CommentId`=VALUES(`CommentId`), `UserEmail`=VALUES(`UserEmail`), `MovieId`=VALUES(`MovieId`), `Text`=VALUES(`Text`), `CreateDate`=VALUES(`CreateDate`);\n");

        System.err.println(builder.toString());
        Statement stmt = con.createStatement();
        stmt.execute(builder.toString());

        con.close();
        stmt.close();
    }

    public void putMovie(Integer id, Movie movie) throws Exception {
        movieRepository.save(movie);
    }

    public Movie getMovie(Integer id) throws Exception {
        return movieRepository.findById(id).get();
    }

    public void putActor(Integer id, Actor actor) throws Exception {
        Connection con = getConnection();
        ActorViewModel model = actor.getModel();
        StringBuilder builder = new StringBuilder();

        builder.append("INSERT INTO `IEMDB`.`Actor`( \n");
        builder.append("`ActorId`,`Name`,`BirthDate`,`Nationality`,`Image`)");
        builder.append("VALUES");
        builder.append(String.format("(%d, \"%s\", \"%s\", \"%s\", \"%s\")",
                model.id,
                model.name,
                model.birthDate,
                model.nationality,
                model.image));
        builder.append("ON DUPLICATE KEY UPDATE ");
        builder.append(
                "`ActorId`=VALUES(`ActorId`), `Name`=VALUES(`Name`), `Nationality`=VALUES(`Nationality`), `BirthDate`=VALUES(`BirthDate`), `Image`=VALUES(`Image`);\n");

        System.err.println(builder.toString());
        Statement stmt = con.createStatement();
        stmt.execute(builder.toString());

        con.close();
        stmt.close();
    }

    public Actor getActor(Integer id) throws Exception {
        Connection con = getConnection();
        StringBuilder builder = new StringBuilder();

        builder.append("SELECT `ActorId`,`Name`,`BirthDate`,`Nationality`,`Image` FROM `IEMDB`.`Actor` \n");
        builder.append(String.format("WHERE ActorId=%d", id));

        Statement stmt = con.createStatement();
        ResultSet result = stmt.executeQuery(builder.toString());

        if (!result.next()) {
            con.close();
            stmt.close();
            throw new ActorNotFound();
        }

        ActorModel model = new ActorModel();
        model.id = result.getInt("ActorId");
        model.name = result.getString("Name");
        model.nationality = result.getString("Nationality");
        model.birthDate = result.getString("BirthDate");
        model.image = result.getString("Image");

        con.close();
        stmt.close();

        return new Actor(model);
    }

    public void putUser(String email, User user) throws Exception {
        Connection con = getConnection();
        UserModel model = user.getModel();
        StringBuilder builder = new StringBuilder();
    
        builder.append("INSERT INTO `IEMDB`.`User`( \n");
        builder.append("`Email`,`Password`,`NickName`,`Name`,`Birthdate`)");
        builder.append("VALUES");
        builder.append(String.format("('%s', '%s', '%s', '%s', '%s');\n",
                model.email,
                model.password,
                model.nickname,
                model.name,
                formatDate(model.birthDate)));
        Statement stmt = con.createStatement();
        try {
            stmt.execute(builder.toString());
        } catch (Exception e) {
            builder = new StringBuilder();
            builder.append("UPDATE `IEMDB`.`User`\n");
            builder.append(
                    String.format("SET `Password`='%s',`NickName`='%s' ,`Name`='%s',`Birthdate`='%s' \n",
                            model.password,
                            model.nickname,
                            model.name,
                            formatDate(model.birthDate)));

            builder.append(String.format("WHERE `Email`='%s'", model.email));
            stmt.execute(builder.toString());
        }
        con.close();
        stmt.close();
    }

    public void putWatchlist(String email, Integer MovieId) throws Exception {
        Connection con = getConnection();
        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO `IEMDB`.`WatchListItem`( \n");
        builder.append("`UserEmail`,`MovieId`)");
        builder.append("VALUES");
        builder.append(String.format("('%s', '%s');\n",
                email,
                MovieId));

        Statement stmt = con.createStatement();

        stmt.execute(builder.toString());

        con.close();
        stmt.close();
    }

    public void putVote(String email, VoteCommentModel model) throws Exception {
        Connection con = getConnection();
        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO `IEMDB`.`Vote`( \n");
        builder.append("`CommentId`,`UserEmail`, `Type`)");
        builder.append("VALUES");
        builder.append(String.format("('%s', '%s', %d)\n",
                model.commentId,
                email,
                model.vote));
        builder.append("ON DUPLICATE KEY UPDATE ");
        builder.append(
                "`CommentId`=VALUES(`CommentId`), `UserEmail`=VALUES(`UserEmail`), `Type`=VALUES(`Type`)\n");

        Statement stmt = con.createStatement();

        stmt.execute(builder.toString());

        con.close();
        stmt.close();
    }

    public void putRateMovie(Integer MovieId, RateModel model) throws Exception {
        Connection con = getConnection();
        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO `IEMDB`.`MovieRate`( \n");
        builder.append("`MovieId`,`UserEmail`,`Rate`)");
        builder.append("VALUES");
        builder.append(String.format("('%s', '%s', %d)\n",
                model.movieId,
                model.userEmail,model.score));
        builder.append("ON DUPLICATE KEY UPDATE ");
        builder.append(
                "`MovieId`=VALUES(`MovieId`), `UserEmail`=VALUES(`UserEmail`), `Rate`=VALUES(`Rate`)\n");
        Statement stmt = con.createStatement();

        stmt.execute(builder.toString());

        con.close();
        stmt.close();
    }

    public void removeWatchlistItem(String email, Integer MovieId) throws Exception {
        Connection con = getConnection();
        StringBuilder builder = new StringBuilder();
        builder.append("DELETE FROM `IEMDB`.`WatchListItem` \n");
        builder.append(String.format("WHERE `UserEmail`='%s' and `MovieId`='%s';\n",
                email,
                MovieId));

        Statement stmt = con.createStatement();

        stmt.execute(builder.toString());

        con.close();
        stmt.close();
    }

    public User getUser(String email) throws Exception {
        Connection con = getConnection();
        StringBuilder builder = new StringBuilder();

        builder.append("SELECT `Email`,`Password`,`NickName`,`Name`,`Birthdate` FROM `IEMDB`.`User` \n");
        builder.append(String.format("WHERE Email='%s'", email));

        Statement stmt = con.createStatement();
        ResultSet result = stmt.executeQuery(builder.toString());

        if (!result.next()) {
            con.close();
            stmt.close();
            throw new UserNotFound();
        }

        UserModel model = new UserModel();
        model.email = result.getString("Email");
        model.password = result.getString("Password");
        model.nickname = result.getString("NickName");
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(result.getString("Birthdate"));
        model.birthDate = date;

        User user = new User(model);

        builder = new StringBuilder();

        builder.append("SELECT `MovieId` FROM `IEMDB`.`WatchListItem` \n");
        builder.append(String.format("WHERE `UserEmail`='%s'", email));

        stmt = con.createStatement();
        result = stmt.executeQuery(builder.toString());

        ArrayList<Integer> watchlist = new ArrayList<Integer>();

        while (result.next()) {
            watchlist.add(result.getInt("MovieId"));
        }
        user.setWatchlist(watchlist);

        con.close();
        stmt.close();

        return user;
    }

    public Comment getComment(Integer id) throws Exception {
        return new Comment(new CommentModel());
    }

    public Collection<Movie> getAllMovies() {
        return movieRepository.findByOrderByImdbRateAsc();
    }

    public Collection<Movie> getAllSortedMovies() {
        return movieRepository.findByOrderByImdbRateAsc();
    }

    public Collection<Movie> getMoviedBetween(Date start, Date end) {
        return movieRepository.findByReleaseDateBetween(start, end);
    }

    public Collection<Movie> getMoviesByGenre(String genre) {
        return movieRepository.findByGenres(genre);
    }

    public Collection<Movie> getMoviesWithDate(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            return movieRepository.findByReleaseDate(simpleDateFormat.parse(date));
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public Collection<Movie> getActorMovies(Integer actorId) {
        return movieRepository.findByCast(actorId);
    }

    public Collection<Movie> getRecommendations(String userEmail) throws Exception {
        return movieRepository.findRecommandationsByUser(userEmail);
    }

    public Collection<Movie> SearchMovieTitle(String term) {
        return movieRepository.findByNameContains(term);
    }

    public Collection<Movie> Sort(String type) {
        if (type == "date") {
            return movieRepository.findByOrderByReleaseDateAsc();
        } else {
            return movieRepository.findByOrderByImdbRateAsc();
        }
    }

    private String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }
}
