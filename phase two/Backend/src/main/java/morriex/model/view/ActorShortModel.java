package morriex.model.view;

public class ActorShortModel implements Component {
    public Integer actorId;
    public Integer age;
    public String name;
    public String image;

    @Override
    public String render() {
        return "<p><a href=\"/actors/" + actorId + "\">" + name + "</a></p>";
    }
}
