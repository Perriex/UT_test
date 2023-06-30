// package morriex;

// import java.util.Date;
// import java.time.ZonedDateTime;

// import morriex.Entity.Actor;
// import morriex.Entity.Comment;
// import morriex.Entity.Movie;
// import morriex.Entity.User;
// import morriex.Model.ActorModel;
// import morriex.Model.CommentModel;
// import morriex.Model.MovieModel;
// import morriex.Model.UserModel;
// import morriex.context.ContextManager;

// public class DataGenerator {

//     public static void GenerateUser(String userEmail, Integer age) throws Exception {
//         UserModel userModel = new UserModel();
//         userModel.birthDate = Date.from(ZonedDateTime.now().minusYears(age).toInstant());
//         userModel.email = userEmail;
//         User user = new User(userModel);
//         ContextManager.getInstance().putUser(userEmail, user);

//     }

//     public static void GenerateMovie(Integer movieId, Integer ageLimit) throws Exception {
//         MovieModel movieModel = new MovieModel();
//         movieModel.id = movieId;
//         movieModel.ageLimit = ageLimit;
//         Movie movie = new Movie(movieModel);
//         ContextManager.getInstance().putMovie(movieId, movie);
//     }

//     public static Movie GenerateMovie(Integer movieId, Integer ageLimit, String[] genres, Date releaseDate) throws Exception {
//         MovieModel movieModel = new MovieModel();
//         movieModel.id = movieId;
//         movieModel.name = "Fight";
//         movieModel.ageLimit = ageLimit;
//         movieModel.genres = genres;
//         movieModel.cast = new Integer[] { 1 };
//         movieModel.releaseDate = releaseDate;
//         Movie movie = new Movie(movieModel);
//         ContextManager.getInstance().putMovie(movieId, movie);

//         return movie;
//     }

//     public static void GenerateActor(Integer actorId) throws Exception {
//         ActorModel actorModel = new ActorModel();
//         actorModel.id = actorId;
//         actorModel.birthDate = "Jun 20, 1999";
//         Actor actor = new Actor(actorModel);
//         ContextManager.getInstance().putActor(actorId, actor);
//     }

//     public static Integer GenerateComment(Integer movieId, String userEmail) {
//         CommentModel commentModel = new CommentModel();
//         commentModel.movieId = movieId;
//         commentModel.userEmail = userEmail;
//         Comment comment = new Comment(commentModel);
//         try {
//             Movie movie = ContextManager.getInstance().getMovie(movieId);
//             movie.addComment(comment);
//             return comment.getCommentId();
//         } catch (Exception e) {
//         }
//         return null;
//     }
// }
