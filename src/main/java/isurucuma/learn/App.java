package isurucuma.learn;

import isurucuma.learn.entities.Passport;
import isurucuma.learn.entities.Person;
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

            Person person = new Person();
            person.setName("Anton");

            Passport passport = new Passport();
            passport.setNumber("1234");

            person.setPassport(passport);

            em.persist(passport);
            em.persist(person);

            TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p WHERE p.passport.number = :number", Person.class);
            query.setParameter("number", "1234");

            // logging the result which is the passport object, here since the loading is set to LAZY, the person object is not loaded
            System.out.println(query.getSingleResult());

            // not we are explictly loading the person object
            System.out.println(query.getSingleResult().getPassport());

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
