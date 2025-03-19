package isurucuma.learn;

import isurucuma.learn.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-fundamentals-persistence-unit");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
//            Product product = new Product();
//            product.setId(4L);
//            product.setName("Book4");
//
//            em.persist(product);

            var p1 = em.getReference(Product.class, 3L);
            System.out.println(p1);

            p1.setName("AnneBook2");
            em.refresh(p1);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
}
