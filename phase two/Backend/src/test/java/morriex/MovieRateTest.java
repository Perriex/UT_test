// package morriex;

// import static org.junit.Assert.assertEquals;

// import org.junit.Before;
// import org.junit.Test;

// import morriex.Entity.Movie;
// import morriex.Model.urlParam.RateModel;
// import morriex.commands.RateMovie;
// import morriex.context.ContextManager;
// import morriex.exception.InvalidRateScore;
// import morriex.exception.MovieNotFound;
// import morriex.exception.UserNotFound;

// public class MovieRateTest {
//     private String userEmail = "test@gmail.com";
//     private Integer movieId = 1;

//     @Before
//     public void setUp() throws Exception {
//         DataGenerator.GenerateUser("1" + userEmail, 15);
//         DataGenerator.GenerateUser("2" + userEmail, 15);
//         DataGenerator.GenerateUser("3" + userEmail, 15);
//         DataGenerator.GenerateMovie(movieId, 14);
//     }

//     @Test
//     public void rateMovie_ValidData_Runs() throws Exception {
//         RateMovie command = new RateMovie();

//         RateModel model = new RateModel();
//         model.movieId = movieId;
//         model.score = 7;
//         model.userEmail = "1" + userEmail;

//         command.handle(model);

//         Movie movie = ContextManager.getInstance().getMovie(movieId);
//         Double rating = 7.0;
//         assertEquals(rating, movie.getRate());

//         RateModel model2 = new RateModel();
//         model2.movieId = movieId;
//         model2.score = 2;
//         model2.userEmail = "2" + userEmail;
//         command.handle(model2);
//         RateModel model3 = new RateModel();
//         model3.movieId = movieId;
//         model3.score = 3;
//         model3.userEmail = "3" + userEmail;

//         command.handle(model3);

//         rating = 4.0;
//         assertEquals(rating, movie.getRate());
//     }

//     @Test
//     public void rateMovie_UserRateTwice_Runs() throws Exception {
//         RateMovie command = new RateMovie();

//         RateModel model = new RateModel();
//         model.movieId = movieId;
//         model.score = 7;
//         model.userEmail = "1" + userEmail;

//         command.handle(model);

//         Movie movie = ContextManager.getInstance().getMovie(movieId);
//         Double rating = 7.0;
//         assertEquals(rating, movie.getRate());

//         RateModel model2 = new RateModel();
//         model2.movieId = movieId;
//         model2.score = 3;
//         model2.userEmail = "1" + userEmail;
//         command.handle(model2);
//         RateModel model3 = new RateModel();
//         model3.movieId = movieId;
//         model3.score = 3;
//         model3.userEmail = "2" + userEmail;

//         command.handle(model3);

//         rating = 3.0;
//         assertEquals(rating, movie.getRate());
//     }

//     @Test(expected = InvalidRateScore.class)
//     public void rateMovie_RateOutOfRangeLow_Throws() throws Exception {
//         RateModel model = new RateModel();
//         model.movieId = movieId;
//         model.score = -1;
//         model.userEmail = "1" + userEmail;
//         RateMovie command = new RateMovie();

//         command.handle(model);
//     }

//     @Test(expected = InvalidRateScore.class)
//     public void rateMovie_RateOutOfRangeHigh_Throws() throws Exception {
//         RateMovie command = new RateMovie();

//         RateModel model2 = new RateModel();
//         model2.movieId = movieId;
//         model2.score = 12;
//         model2.userEmail = "1" + userEmail;

//         command.handle(model2);
//     }

//     @Test(expected = MovieNotFound.class)
//     public void rateMovie_MovieNotExits_Throws() throws Exception {
//         RateModel model = new RateModel();
//         model.movieId = 10;
//         model.score = 5;
//         model.userEmail = "1" + userEmail;
//         RateMovie command = new RateMovie();

//         command.handle(model);
//     }

//     @Test(expected = UserNotFound.class)
//     public void rateMovie_UserNotFound_Throws() throws Exception {
//         RateModel model = new RateModel();
//         model.movieId = 10;
//         model.score = 5;
//         model.userEmail = "test5@mail.com";
//         RateMovie command = new RateMovie();

//         command.handle(model);
//     }

// }
