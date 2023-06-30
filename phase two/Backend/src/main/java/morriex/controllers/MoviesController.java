package morriex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import morriex.Entity.Movie;
import morriex.Model.CommentModel;
import morriex.Model.urlParam.AddCommentModel;
import morriex.Model.urlParam.RateModel;
import morriex.Model.urlParam.VoteCommentModel;
import morriex.Model.view.MovieListModel;
import morriex.Model.view.MovieViewModel;
import morriex.commands.GetMovies;
import morriex.commands.RateMovie;
import morriex.commands.VoteComment;
import morriex.commands.console.AddComment;
import morriex.context.MovieRepository;
import morriex.context.UserContext;

@RestController
public class MoviesController {

    @Autowired
    MovieRepository repository;

    @GetMapping("Movie")
    public ResponseEntity<MovieListModel> getMovies(@RequestParam(required = false) String term
        , @RequestParam(required = false) String search
        , @RequestParam(required = false) String sort) throws Exception {
        GetMovies command = new GetMovies();

        MovieListModel movies = null;
        movies = command.handle(term, search, sort);

        return ResponseEntity.ok(movies);
    }

    @GetMapping("Movie/{movieId}")
    public ResponseEntity<MovieViewModel> getMovieById(@PathVariable Integer movieId) throws Exception {
        try {
            Movie movie = repository.findById(movieId).get();
            return ResponseEntity.ok(movie.getModel());
        } catch (Exception e) {
            return new ResponseEntity<MovieViewModel>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("Movie/{movieId}/Rate/{score}")
    private void rateMovie(@PathVariable Integer movieId, @PathVariable Integer score) throws Exception {
        RateModel model = new RateModel();
        model.movieId = movieId;
        model.score = score;
        model.userEmail = UserContext.email;

        RateMovie command = new RateMovie();
        command.handle(model);
    }

    @PostMapping("Comment/{commentId}/like")
    private ResponseEntity<String> likeComment(@PathVariable Integer commentId) throws Exception {
        VoteCommentModel model = new VoteCommentModel();
        model.commentId = commentId;
        model.vote = 1;
        model.userEmail = UserContext.email;

        VoteComment command = new VoteComment();

        command.handle(model);

        return ResponseEntity.ok("Successful like");
    }

    @PostMapping("Comment/{commentId}/dislike")
    private ResponseEntity<String> dislikeComment(@PathVariable Integer commentId) throws Exception {
        VoteCommentModel model = new VoteCommentModel();
        model.commentId = commentId;
        model.vote = -1;
        model.userEmail = UserContext.email;

        VoteComment command = new VoteComment();

        command.handle(model);

        return ResponseEntity.ok("Successful dislike");
    }

    @PostMapping("Movie/{movieId}/Comment")
    private ResponseEntity<String> comment(@PathVariable Integer movieId, @RequestBody AddCommentModel body)
            throws Exception {
        CommentModel model = new CommentModel();
        model.movieId = movieId;
        model.text = body.text;
        model.userEmail = UserContext.email;

        AddComment command = new AddComment();

        command.handle(model);

        return ResponseEntity.ok("Comment Successfully Submited");
    }
}
