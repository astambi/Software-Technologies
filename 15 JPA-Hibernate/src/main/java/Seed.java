import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import java.util.*;

// to CREATE/ UPDATE database tables modify persistence.xml accordingly:
//        <property name="hibernate.hbm2ddl.auto" value="create" />
//        <property name="hibernate.hbm2ddl.auto" value="update" />

public class Seed {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("blog-db");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            for (int user = 1; user <= 10; user++) {
                // create new user
                User newUser = new User();
                newUser.setUsername("pesho" + new Date().getTime());
                String hash = bCrypt("123");
                newUser.setPasswordHash(hash);
                newUser.setFullName("P.Petrov" + user);

                em.persist(newUser);
                System.out.println("Created new user #" + newUser.getId());

                // create user posts
                for (int post = 1; post <= 10; post++) {
                    Post newPost = new Post();
                    newPost.setTitle("Post Title " + (post + user * 10));
                    newPost.setBody("<p>Body" + post + "</p>");
                    newPost.setAuthor(newUser);

                    em.persist(newPost);
                    System.out.println("Created new post #" + newPost.getId());
                }
            }
            em.getTransaction().commit();
        }
        finally {
            em.close();
            emf.close();
        }
    }

    private static String bCrypt(String password) {
        String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
        return passwordHash;
    }
}
