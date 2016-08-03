import javax.persistence.*;
import java.time.*;
import java.util.*;

public class NativeSQL {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("blog-db");
        EntityManager em = emf.createEntityManager();

        try {
            LocalDateTime startDate =
                    LocalDateTime.parse("2016-05-19T12:00:00");
            LocalDateTime endDate = LocalDateTime.now();

            Query postsQuery = em.createNativeQuery(
                    "SELECT id, title, date, body, author_id FROM posts " +
                    "WHERE CONVERT(date, Date) " +
                    "BETWEEN :startDate AND :endDate", Post.class)
                    .setParameter("startDate", startDate)
                    .setParameter("endDate", endDate);

            List<Post> posts = postsQuery.getResultList();

            for (Post post : posts)
                System.out.println(post);
        }
        finally {
            em.close();
            emf.close();
        }
    }
}
