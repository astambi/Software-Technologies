import javax.persistence.*;
import java.util.*;

public class ListAllPosts {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("blog-db");
        EntityManager em = emf.createEntityManager();

        try {
            Query allPostsQuerySlow = em.createQuery(
                    "SELECT p FROM Post p");
            Query allPostsQuery = em.createQuery(
                    "SELECT p FROM Post p JOIN FETCH p.author");
            List<Post> posts =
                    allPostsQuery.getResultList();
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