package morriex.Model.view;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MovieShortModel {
    public Integer movieId;
    public String name;
    public String director;
    public Double rating;
    public String summary;
    public Double imdbRate;
    public Integer duration;
    public Integer ageLimit;
    @JsonFormat(pattern="yyyy-MM-dd")
    public Date releaseDate;
    public String image;
    public String coverImage;
    public String[] genres;
    public String[] writers;
    public ActorShortModel[] cast;
}
