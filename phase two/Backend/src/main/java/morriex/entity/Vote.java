package morriex.entity;

public class Vote {
    String userEmail;
    Integer type;

    public Vote(String _userEmail, Integer _type) {
        userEmail = _userEmail;
        type = _type;
    }

    private Vote() {
    }

    public Integer getType() {
        return type;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
