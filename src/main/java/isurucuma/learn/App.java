package isurucuma.learn;

import isurucuma.learn.entities.Book;
import isurucuma.learn.entities.ElectronicDevice;
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

            // Create a new book
            Book book = new Book();
            book.setName("Effective Java");
            book.setAuthor("Joshua Bloch");
            book.setIsbn("978-0134686097");
            em.persist(book);

            // Create a new electronic device
            ElectronicDevice device = new ElectronicDevice();
            device.setName("Laptop");
            device.setVoltage(220);
            em.persist(device);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
