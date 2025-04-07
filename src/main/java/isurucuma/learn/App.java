package isurucuma.learn;

import isurucuma.learn.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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
//            Product product = new Product();
//            product.setName("Product 1");
//            em.persist(product);
//
//            product = new Product();
//            product.setName("Product 2");
//            em.persist(product);

            // give me JPQL query to select p.name LIKE '%2'

            em.createQuery("SELECT p FROM Product p WHERE p.name LIKE '%2'", Product.class)
                    .getResultList()
                    .forEach(System.out::println);

            // give me JPQL query for a count
            Long count = em.createQuery("SELECT COUNT(p) FROM Product p", Long.class)
                    .getSingleResult();
            System.out.println("Count: " + count);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
