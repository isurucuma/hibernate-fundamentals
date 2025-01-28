package isurucuma.learn;

import isurucuma.learn.entities.Product;
import isurucuma.learn.persistance.CustomPersistenceUnitInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-fundamentals-persistence-unit");
        // represents the context

        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(), new HashMap<>());

        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Product product = new Product();
            product.setId(2L);
            product.setName("Book2");

            em.persist(product);
            em.getTransaction().commit();
        }
    }
}
