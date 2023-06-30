package morriex.commands.console;

import morriex.Entity.User;
import morriex.Model.UserModel;
import morriex.commands.Command;
import morriex.context.ContextManager;

public class AddUser extends Command {
    public String handle(UserModel model) throws Exception {
        User user = new User(model);
        ContextManager.getInstance().putUser(model.email, user);
        return  "user added successfully";
    }
}
