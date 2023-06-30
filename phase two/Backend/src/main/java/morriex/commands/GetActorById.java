package morriex.commands;

import morriex.Entity.Actor;
import morriex.Model.urlParam.GetActorByIdModel;
import morriex.Model.view.ActorViewModel;
import morriex.context.ContextManager;

public class GetActorById {

    public ActorViewModel handle(GetActorByIdModel model) throws Exception {

        Actor actor = ContextManager.getInstance().getActor(model.actorId);
        ActorViewModel result = actor.getModel();

        return result;
    }
}
