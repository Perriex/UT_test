// package morriex;

// import static org.junit.Assert.assertEquals;

// import java.text.DateFormat;
// import java.text.SimpleDateFormat;
// import java.util.Date;

// import org.junit.After;
// import org.junit.Before;
// import org.junit.Test;

// import morriex.model.urlParam.GetMovieByIdModel;
// import morriex.model.urlParam.GetMoviesByGenreModel;
// import morriex.model.urlParam.SearchMovieByReleaseDateModel;
// import morriex.model.view.MovieListModel;
// import morriex.model.view.MovieViewModel;
// import morriex.commands.GetMovieById;
// import morriex.commands.GetMovieList;
// import morriex.commands.GetMoviesByGenre;
// import morriex.commands.SearchMoviesByReleaseDate;
// import morriex.exception.MovieNotFound;

// public class MovieQueryTest {

//     private Integer genre1Count = 3;
//     private Integer genre2Count = 3;
//     private String[] genres1 = new String[] { "Action", "Comedy", "Musical" };
//     private String[] genres2 = new String[] { "Action", "Thriller" };

//     @Before
//     public void setUp() throws Exception {
//         DataGenerator.GenerateActor(1);
//         String str_date = "1991-June-07";
//         DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
//         Date date = formatter.parse(str_date);
//         int i = 1;
//         for (; i < genre1Count; i++) {
//             DataGenerator.GenerateMovie(i, 0, genres1, date);
//         }
//         str_date = "2020-June-07";
//         formatter = new SimpleDateFormat("dd-MMM-yy");
//         date = formatter.parse(str_date);
//         for (; i <= genre1Count + genre2Count; i++) {
//             DataGenerator.GenerateMovie(i, 0, genres2, date);
//         }
//     }

//     @After
//     public void teardown() {
//     }

//     @Test
//     public void getMovieById_MovieExists_Runs() throws Exception {
//         GetMovieByIdModel model = new GetMovieByIdModel();
//         model.movieId = 1;
//         GetMovieById command = new GetMovieById();

//         MovieViewModel movie = command.handle(model);

//         assertEquals((Integer) 0, movie.ageLimit);
//         assertEquals(genres1.length, movie.genres.length);
//     }

//     @Test(expected = MovieNotFound.class)
//     public void getMovieById_MovieDoNotExists_Throws() throws Exception {
//         GetMovieByIdModel model = new GetMovieByIdModel();
//         model.movieId = 10000;
//         GetMovieById command = new GetMovieById();

//         command.handle(model);
//     }

//     @Test
//     public void getMovieByGenre_MoviesExists_Runs() throws Exception {
//         GetMoviesByGenreModel model = new GetMoviesByGenreModel();
//         model.genre = "Action";
//         GetMoviesByGenre command = new GetMoviesByGenre();

//         MovieListModel movies = command.handle(model);

//         assertEquals(genre1Count + genre2Count, movies.moviesList.size());
//     }

//     @Test
//     public void getMoviesList_MoviesExists_Runs() throws Exception {
//         GetMovieList command = new GetMovieList();

//         MovieListModel moveis = command.handle();

//         assertEquals(genre1Count + genre2Count, moveis.moviesList.size());
//     }

//     @Test
//     public void getMovieByGenre_GetAllMovies_Runs() throws Exception {
//         GetMoviesByGenre getMoviesByGenre = new GetMoviesByGenre();

//         GetMoviesByGenreModel model = new GetMoviesByGenreModel();
//         model.genre = "Action";
//         MovieListModel output = getMoviesByGenre.handle(model);

//         assertEquals(output.moviesList.size(), 6);
//     }

//     @Test
//     public void getMovieByDate_GetAllMovies_Runs() throws Exception {
//         SearchMoviesByReleaseDate getMoviesByGenre = new SearchMoviesByReleaseDate();

//         SearchMovieByReleaseDateModel model = new SearchMovieByReleaseDateModel();
//         model.startYear = 2000;
//         model.endYear = 2020;
//         MovieListModel output = getMoviesByGenre.handle(model);

//         assertEquals(output.moviesList.size(), 6);
//     }

// }
