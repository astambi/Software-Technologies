import javax.persistence.*;
import java.util.Date;

public class EditUser {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("blog-db");
        EntityManager em = emf.createEntityManager();

        try {
//            Load an existing user by ID
            User firstUser = em.find(User.class, 1L);

//            Modify the User
            firstUser.setPasswordHash("" + new Date().getTime());
            firstUser.setFullName(firstUser.getFullName() + "2");

//            Persist pending changes
            em.getTransaction().begin();
            em.persist(firstUser);
            em.getTransaction().commit();

            System.out.println(
                    "Edited existing user #" + firstUser.getId());
        }
        finally {
            em.close();
            emf.close();
        }
    }
}
