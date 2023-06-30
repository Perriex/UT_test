package morriex.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Rating {
    String userEmail;
    Integer rate;

    public Rating(String _userEmail, Integer _rate) {
        userEmail = _userEmail;
        rate = _rate;
    }
    private Rating(){}

    public String getUserEmail() {
        return userEmail;
    }

    public Integer getRate() {
        return rate;
    }
}
