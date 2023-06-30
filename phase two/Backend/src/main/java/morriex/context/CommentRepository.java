package morriex.context;

import org.springframework.stereotype.Repository;

import morriex.Entity.Comment;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

}
