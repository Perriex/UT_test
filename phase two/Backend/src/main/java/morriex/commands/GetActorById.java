package morriex.commands;

import morriex.entity.Actor;
import morriex.model.urlParam.GetActorByIdModel;
import morriex.model.view.ActorViewModel;
import morriex.context.ContextManager;

public class GetActorById {

    public ActorViewModel handle(GetActorByIdModel model) throws Exception {

        Actor actor = ContextManager.getInstance().getActor(model.actorId);
        ActorViewModel result = actor.getModel();

        return result;
    }
}
