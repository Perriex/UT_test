package morriex.Model.view;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MovieViewModel {
    public Integer movieId;
    public String name;
    public String summary;
    @JsonFormat(pattern="yyyy-MM-dd")
    public Date releaseDate;
    public String director;
    public Integer ageLimit;
    public Double rating;
    public Double imdbRate;
    public Integer duration;
    public String image;
    public String coverImage;
    public String[] genres;
    public String[] writers;
    public ActorShortModel[] cast;
    public CommentViewModel[] comments;
}