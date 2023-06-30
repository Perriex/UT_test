package morriex.Entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

import morriex.Model.UserModel;
import morriex.exception.MovieAlreadyExists;
import morriex.exception.MovieNotFound;
import morriex.utility.PasswordAuthentication;

@Entity
public class User {
    @Id
    String email;
    String password;
    String nickname;
    String name;
    Date birthDate;

    ArrayList<Integer> watchList;

    public User(UserModel model) {
        super();
        email = model.email;
        password = model.password;
        nickname = model.nickname;
        name = model.name;
        birthDate = model.birthDate;
        watchList = new ArrayList<>();
    }

    public void hassPass(){
        PasswordAuthentication passwordAuthentication = new PasswordAuthentication();
        password = passwordAuthentication.hash(password);
    }

    public void setWatchlist(ArrayList<Integer> _watchList) {
        watchList = _watchList;
    }

    public void addToWatch(Integer movieId) throws Exception {
        if (watchList.contains(movieId)) {
            throw new MovieAlreadyExists();
        }
        watchList.add(movieId);
    }

    public void removeFromWatch(Integer movieId) throws Exception {
        Integer index = watchList.indexOf(movieId);
        if (index < 0)
            throw new MovieNotFound();

        watchList.remove(movieId);
    }

    public int getAge() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthDate);
        int start = calendar.get(Calendar.YEAR);
        calendar.setTime(new Date());
        int end = calendar.get(Calendar.YEAR);
        return end - start;
    }

    public ArrayList<Integer> getWatch() {
        return watchList;
    }

    public UserModel getModel() {
        UserModel model = new UserModel();
        model.email = email;
        model.name = name;
        model.birthDate = birthDate;
        model.nickname = nickname;
        model.password = password;  

        return model;
    }

    public Boolean checkPassword(String input) {
        PasswordAuthentication passwordAuthentication = new PasswordAuthentication();
        System.err.println(password);
        System.err.println(input);
        return passwordAuthentication.authenticate(input, password);
    }
}
