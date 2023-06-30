package morriex.Entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Id;

import morriex.Model.CommentModel;

@Entity
public class Comment {
    private static Integer idCounter = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer commentId;
    Integer movieId;
    String userEmail;
    String text;
    @Column(name = "CreateDate")
    Date date;

    @ElementCollection
    @CollectionTable(name = "Vote", joinColumns = @JoinColumn(name = "CommentId"))
    @AttributeOverrides({
            @AttributeOverride(name = "userEmail", column = @Column(name = "UserEmail")),
            @AttributeOverride(name = "type", column = @Column(name = "Type"))
    })
    Set<Vote> votes = new HashSet<>();

    public Integer getCommentId() {
        return commentId;
    }

    public String getEmail() {
        return userEmail;
    }

    public String getText() {
        return text;
    }

    public Integer getMovieId() {
        return movieId;
    }

    private Comment() {
    }

    public Comment(CommentModel model) {
        super();
        commentId = idCounter++;
        movieId = model.movieId;
        userEmail = model.userEmail;
        text = model.text;
        date = model.date;
    }

    public void addVote(Integer vote, String email) {
        votes.add(new Vote(email, vote));
    }

    public Integer getLikes() {
        Integer likeCount = 0;
        for (Vote vote : votes) {
            if (vote.type == 1)
                likeCount++;
        }

        return likeCount;
    }

    public Integer getDislikes() {
        Integer dislikeCount = 0;
        for (Vote vote : votes) {
            if (vote.type == -1)
                dislikeCount++;
        }

        return dislikeCount;
    }

}
