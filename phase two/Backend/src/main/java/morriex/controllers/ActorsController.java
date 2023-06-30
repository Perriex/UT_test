package morriex.controllers;

import morriex.entity.Actor;
import morriex.model.view.ActorViewModel;
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
