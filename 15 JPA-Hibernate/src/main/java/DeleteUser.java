import javax.persistence.*;

public class DeleteUser {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("blog-db");
        EntityManager em = emf.createEntityManager();

        try {
            // Load an existing user by ID
            User firstUser = em.find(User.class, 1L);

            // Delete the user along with its posts
            em.getTransaction().begin();

            for (Post post : firstUser.getPosts())
                em.remove(post);
            em.remove(firstUser);

            em.getTransaction().commit();

            System.out.println("Deleted existing user #" +
                    firstUser.getId());
        }
        finally {
            em.close();
            emf.close();
        }
    }
}
