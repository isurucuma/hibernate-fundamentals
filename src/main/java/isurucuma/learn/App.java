package isurucuma.learn;

import isurucuma.learn.entities.Product;
import isurucuma.learn.persistance.CustomPersistenceUnitInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        // represents the context

        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show.sql", "true");
        props.put("hibernate.hbm2ddl.auto", "create");

        try (
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-fundamentals-persistence-unit");
                EntityManager em = emf.createEntityManager()
        ) {
            em.getTransaction().begin();
            Product product = new Product();
            product.setId(2L);
            product.setName("Book2");

            em.persist(product);

            var p1 = em.find(Product.class, 2L);
            System.out.println(p1.getName());

            em.getTransaction().commit();
        }
    }
}
