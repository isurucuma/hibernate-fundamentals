package isurucuma.learn;

import isurucuma.learn.entities.Group;
import isurucuma.learn.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.List;
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
            Group g1 = new Group();
            g1.setName("g1");

            Group g2 = new Group();
            g2.setName("g2");

            User u1 = new User();
            u1.setName("u1");

            User u2 = new User();
            u2.setName("u2");

            u1.setGroups(List.of(g1));
            g1.setUsers(List.of(u1, u2));

            u2.setGroups(List.of(g1, g2));
            g2.setUsers(List.of(u2));

            em.persist(g1);
            em.persist(g2);
            em.persist(u1);
            em.persist(u2);


            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
