package morriex.Entity;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import morriex.Model.ActorModel;
import morriex.Model.view.ActorShortModel;
import morriex.Model.view.ActorViewModel;
import morriex.Model.view.MovieShortModel;
import morriex.context.ContextManager;

@Entity
public class Actor {
    @Id
    Integer id;
    String name;
    String birthDate;
    String nationality;
    String image;

    public Actor(ActorModel model) {
        super();
        id = model.id;
        name = model.name;
        birthDate = model.birthDate;
        nationality = model.nationality;
        image = model.image;
    }

    public ActorShortModel getShortModel() {
        ActorShortModel model = new ActorShortModel();
        model.actorId = id;
        model.name = name;
        model.age = getAge();
        model.image = image;
        return model;
    }

    public ActorViewModel getModel() throws Exception {
        ActorViewModel model = new ActorViewModel();
        model.id = id;
        model.name = name;
        model.birthDate = birthDate;
        model.nationality = nationality;
        model.image = image;

        Collection<Movie> movies = ContextManager.getInstance().getActorMovies(id);
        model.movies = new MovieShortModel[movies.size()];
        int i = 0;
        for (Movie movie : movies) {
            model.movies[i++] = movie.getShortModel();
        }
        return model;
    }

    private Integer getAge() {
        try {
            int start = Integer.parseInt(birthDate.substring(birthDate.length() - 4));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            int end = calendar.get(Calendar.YEAR);
            return end - start;
        } catch (Exception ignored) {
            return null;
        }
    }
}
