package morriex.commands.console;

import morriex.Entity.Movie;
import morriex.Model.MovieModel;
import morriex.commands.Command;
import morriex.context.ContextManager;

public class AddMovie extends Command {
    public String handle(MovieModel model) throws Exception {
        for (Integer actorId : model.cast) {
            ContextManager.getInstance().getActor(actorId);
        }
        Movie movie = new Movie(model);
        ContextManager.getInstance().putMovie(model.id, movie);
        return "movie added successfully";
    }
}
