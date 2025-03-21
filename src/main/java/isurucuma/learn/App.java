package isurucuma.learn;

import isurucuma.learn.entities.Product;
import isurucuma.learn.entities.keys.ProductKey;
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
            Product product = new Product();
            product.setName("Product 1");
            product.setCode("P1");
            product.setNumber("N1");


            em.persist(product);

            ProductKey productKey = new ProductKey("N1", "P1");
            Product productReference = em.getReference(Product.class, productKey);
            System.out.println(productReference);

            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
}
