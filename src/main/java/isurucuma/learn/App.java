package isurucuma.learn;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-fundamentals-persistence-unit");
        EntityManager em = emf.createEntityManager(); // represents the context

        em.getTransaction().begin();


        em.getTransaction().commit();


    }
}
