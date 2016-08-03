import javax.persistence.*;
import java.util.*;

public class ListsPostsByUsername {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("blog-db");
        EntityManager em = emf.createEntityManager();

        try {
            Query peshoPosts = em.createQuery(
                    "FROM Post p JOIN FETCH p.author " +
                    "WHERE p.author.username " +
                    "LIKE CONCAT(:username, '%') ")
                    .setParameter("username", "pesho");

            List<Post> posts = peshoPosts.getResultList();

            for (Post post : posts) {
                System.out.println(post);
            }
        }
        finally {
            em.close();
            emf.close();
        }
    }
}
