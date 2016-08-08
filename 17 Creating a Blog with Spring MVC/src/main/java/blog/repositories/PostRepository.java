package blog.repositories;

import blog.models.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT p FROM Post p " +
            "LEFT JOIN FETCH p.author " +
            "ORDER BY p.date DESC")
    List<Post> findLatest5Posts(Pageable pageable);
}
