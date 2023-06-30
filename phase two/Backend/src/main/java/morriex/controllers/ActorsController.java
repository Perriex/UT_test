package morriex.controllers;

import morriex.Entity.Actor;
import morriex.Model.view.ActorViewModel;
import morriex.context.ContextManager;
import org.springframework.web.bind.annotation.*;

@RestController
public class ActorsController {
    @GetMapping("Actor/{id}")
    public ActorViewModel getActorById(@PathVariable Integer id) throws Exception {
        Actor actor = ContextManager.getInstance().getActor(id);
        return actor.getModel();
    }
}
