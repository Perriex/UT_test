// package morriex;

// import static org.junit.Assert.assertEquals;

// import org.junit.Before;
// import org.junit.Test;

// import morriex.entity.Comment;
// import morriex.model.urlParam.VoteCommentModel;
// import morriex.commands.VoteComment;
// import morriex.context.ContextManager;
// import morriex.exception.InvalidVoteValue;

// public class VoteCommentTest {
//     private String userEmail = "test@gmail.com";
//     private Integer commentId;
//     private Integer movieId = 1;

//     @Before
//     public void setUp() throws Exception {
//         DataGenerator.GenerateUser(userEmail, 15);
//         DataGenerator.GenerateUser("1"+userEmail, 15);
//         DataGenerator.GenerateUser("2"+userEmail, 15);
//         DataGenerator.GenerateUser("3"+userEmail, 15);
//         DataGenerator.GenerateUser("4"+userEmail, 15);
//         DataGenerator.GenerateMovie(movieId, 12);
//         commentId = DataGenerator.GenerateComment(movieId, userEmail);
//     }

//     @Test
//     public void voteComment_ValidData_Runs() throws Exception {
//         VoteCommentModel model = new VoteCommentModel();
//         model.commentId = commentId;
//         model.userEmail = userEmail;
//         model.vote = -1;
//         VoteComment command = new VoteComment();

//         command.handle(model);

//         Comment comment = ContextManager.getInstance().getComment(commentId);
//         Integer expectedLikes = 0;
//         Integer expectedDislikes = 1;

//         assertEquals(expectedDislikes, comment.getDislikes());
//         assertEquals(expectedLikes, comment.getLikes());
//     }

//     @Test
//     public void voteComment_UserVoteTwice_Runs() throws Exception {
//         VoteCommentModel model = new VoteCommentModel();
//         model.commentId = commentId;
//         model.userEmail = userEmail;
//         model.vote = -1;
//         VoteComment command = new VoteComment();

//         command.handle(model);

//         Comment comment = ContextManager.getInstance().getComment(commentId);
//         Integer expectedLikes = 0;
//         Integer expectedDislikes = 1;

//         assertEquals(expectedDislikes, comment.getDislikes());
//         assertEquals(expectedLikes, comment.getLikes());

//         model = new VoteCommentModel();
//         model.commentId = commentId;
//         model.userEmail = userEmail;
//         model.vote = 1;
//         command.handle(model);
//         comment = ContextManager.getInstance().getComment(commentId);
//         expectedLikes = 1;
//         expectedDislikes = 0;

//         assertEquals(expectedDislikes, comment.getDislikes());
//         assertEquals(expectedLikes, comment.getLikes());
//     }

//     @Test(expected = InvalidVoteValue.class)
//     public void voteComment_InvalidVoteLow_Runs() throws Exception {
//         VoteCommentModel model = new VoteCommentModel();
//         model.commentId = commentId;
//         model.userEmail = userEmail;
//         model.vote = -5;
//         VoteComment command = new VoteComment();

//         command.handle(model);
//     }

//     @Test(expected = InvalidVoteValue.class)
//     public void voteComment_InvalidVoteHigh_Runs() throws Exception {
//         VoteCommentModel model = new VoteCommentModel();
//         model.commentId = commentId;
//         model.userEmail = userEmail;
//         model.vote = 3;
//         VoteComment command = new VoteComment();

//         command.handle(model);
//     }

//     @Test
//     public void voteComment_GetAllVotes_Runs() throws Exception {
//         VoteComment command = new VoteComment();

//         VoteCommentModel model = new VoteCommentModel();
//         model.commentId = commentId;
//         model.userEmail = "1" + userEmail;
//         model.vote = -1;

//         command.handle(model);

//         model = new VoteCommentModel();
//         model.commentId = commentId;
//         model.userEmail = "2" + userEmail;
//         model.vote = -1;

//         command.handle(model);

//         model = new VoteCommentModel();
//         model.commentId = commentId;
//         model.userEmail = "3" + userEmail;
//         model.vote = 1;

//         command.handle(model);

//         model = new VoteCommentModel();
//         model.commentId = commentId;
//         model.userEmail = "4" + userEmail;
//         model.vote = 0;

//         command.handle(model);

//         Comment comment = ContextManager.getInstance().getComment(commentId);
//         Integer expectedLikes = 1;
//         Integer expectedDislikes = 2;

//         assertEquals(expectedDislikes, comment.getDislikes());
//         assertEquals(expectedLikes, comment.getLikes());
//     }
// }
