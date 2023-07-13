package morriex.model;

import java.util.Date;

public class MovieModel {
    public Integer id;
    public String name;
    public String summary;
    public Date releaseDate;
    public String director;
    public Double imdbRate;
    public Integer ageLimit;
    public Integer duration;
    public String[] genres = new String[0];
    public String[] writers = new String[0];
    public Integer[] cast = new Integer[0];
    public String image;
    public String coverImage;
}
