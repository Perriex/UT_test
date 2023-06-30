// package morriex;

// import static org.junit.Assert.assertEquals;

// import java.util.ArrayList;

// import org.junit.Before;
// import org.junit.Test;

// import morriex.Entity.User;
// import morriex.Model.urlParam.AddToWatchListModel;
// import morriex.Model.urlParam.GetWatchListModel;
// import morriex.Model.urlParam.RemoveFromWatchListModel;
// import morriex.Model.view.WatchListModel;
// import morriex.commands.AddToWatchList;
// import morriex.commands.GetWatchList;
// import morriex.commands.RemoveFromWatchList;
// import morriex.context.ContextManager;
// import morriex.exception.AgeLimitError;
// import morriex.exception.MovieAlreadyExists;
// import morriex.exception.MovieNotFound;

// public class WatchTest {
//     private String userEmail = "test@gmail.com";
//     private String email = "user@test.com";
//     private String[] genres1 = new String[] { "Action", "Comedy", "Musical" };

//     @Before
//     public void setUp() throws Exception {
//         DataGenerator.GenerateUser(userEmail, 15);
//         DataGenerator.GenerateActor(1);
//         int i = 1;
//         for (; i < 3; i++) {
//             DataGenerator.GenerateMovie(i, 0, genres1, null);
//         }
//         DataGenerator.GenerateUser(email, 15);
//     }

//     @Test
//     public void addToWatch_ValidData_Runs() throws Exception {
//         Integer movieId = 1;
//         DataGenerator.GenerateMovie(movieId, 10);
//         AddToWatchListModel model = new AddToWatchListModel();
//         model.movieId = movieId;
//         model.userEmail = userEmail;
//         AddToWatchList command = new AddToWatchList();

//         command.handle(model);

//         User user = ContextManager.getInstance().getUser(userEmail);
//         ArrayList<Integer> watch = user.getWatch();

//         assertEquals(1, watch.size());
//         assertEquals(model.movieId, watch.get(0));
//     }

//     @Test(expected = AgeLimitError.class)
//     public void addToWatch_AgeLimitNotMet_Throws() throws Exception {
//         Integer movieId = 1;
//         DataGenerator.GenerateMovie(movieId, 20);
//         AddToWatchListModel model = new AddToWatchListModel();
//         model.movieId = movieId;
//         model.userEmail = userEmail;
//         AddToWatchList command = new AddToWatchList();

//         command.handle(model);
//     }

//     @Test(expected = MovieAlreadyExists.class)
//     public void addToWatch_DuplicateMovie_Throws() throws Exception {
//         Integer movieId = 1;
//         DataGenerator.GenerateMovie(movieId, 10);
//         AddToWatchListModel model = new AddToWatchListModel();
//         model.movieId = movieId;
//         model.userEmail = userEmail;
//         AddToWatchList command = new AddToWatchList();

//         command.handle(model);
//         command.handle(model);
//     }

//     @Test
//     public void removeFromWatch_MovieExsits_Runs() throws Exception {
//         Integer movieId = 1;
//         DataGenerator.GenerateMovie(movieId, 10);
//         RemoveFromWatchListModel model = new RemoveFromWatchListModel();
//         model.movieId = movieId;
//         model.userEmail = userEmail;
//         User user = ContextManager.getInstance().getUser(userEmail);
//         user.addToWatch(movieId);

//         RemoveFromWatchList command = new RemoveFromWatchList();

//         command.handle(model);

//         ArrayList<Integer> watch = user.getWatch();

//         assertEquals(0, watch.size());
//     }

//     @Test(expected = MovieNotFound.class)
//     public void removeFromWatch_NotExists_Throws() throws Exception {
//         Integer movieId = 1;
//         DataGenerator.GenerateMovie(movieId, 10);
//         RemoveFromWatchListModel model = new RemoveFromWatchListModel();
//         model.movieId = movieId;
//         model.userEmail = userEmail;

//         RemoveFromWatchList command = new RemoveFromWatchList();

//         command.handle(model);
//     }


//     @Test
//     public void getWatchList_CorrectData_Runs() throws Exception {
//         AddToWatchList addToWatchList = new AddToWatchList();
//         AddToWatchListModel model = new AddToWatchListModel();
//         model.movieId = 1;
//         model.userEmail = email;
//         addToWatchList.handle(model);

//         AddToWatchListModel model2 = new AddToWatchListModel();
//         model2.movieId = 2;
//         model2.userEmail = email;
//         addToWatchList.handle(model2);

//         GetWatchList getWatchList = new GetWatchList();

//         GetWatchListModel input = new GetWatchListModel();
//         input.userEmail = email;

//         WatchListModel output = getWatchList.handle(input);
//         assertEquals(2, output.watchList.size());

//     }

//     @Test(expected = MovieAlreadyExists.class)
//     public void getWatchList_AddSameMovie_Throws() throws Exception {
//         AddToWatchList addToWatchList = new AddToWatchList();
//         AddToWatchListModel model = new AddToWatchListModel();
//         model.movieId = 1;
//         model.userEmail = email;
//         addToWatchList.handle(model);

//         addToWatchList.handle(model);
//     }
// }
