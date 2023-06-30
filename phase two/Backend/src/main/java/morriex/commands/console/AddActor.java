package morriex.commands.console;

import morriex.Entity.Actor;
import morriex.Model.ActorModel;
import morriex.commands.Command;
import morriex.context.ContextManager;

public class AddActor extends Command {

    public String handle(ActorModel model) throws Exception {
        Actor actor = new Actor(model);
        ContextManager.getInstance().putActor(model.id, actor);
        return "actor added successfully";
    }
}
