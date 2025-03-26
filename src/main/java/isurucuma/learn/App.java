package isurucuma.learn;

import isurucuma.learn.entities.Comment;
import isurucuma.learn.entities.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        // represents the context

        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show.sql", "true");
        props.put("hibernate.hbm2ddl.auto", "create");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-fundamentals-persistence-unit");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Post post1 = new Post();
            post1.setTitle("First post");
            post1.setContent("This is my first post");

            Comment comment1 = new Comment();
            comment1.setComment("This is my first comment");
            comment1.setPost(post1);

            em.persist(post1);
            em.persist(comment1);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
