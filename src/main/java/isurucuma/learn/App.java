package isurucuma.learn;

import isurucuma.learn.dto.CountedEnrollmentForStudent;
import isurucuma.learn.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.HashMap;
import java.util.Map;

/**
 * CREATE TABLE Student (
 * id BIGINT PRIMARY KEY,
 * name VARCHAR(255) NOT NULL
 * );
 * <p>
 * CREATE TABLE Course (
 * id BIGINT PRIMARY KEY,
 * title VARCHAR(255) NOT NULL
 * );
 * <p>
 * CREATE TABLE Enrollment (
 * id BIGINT PRIMARY KEY,
 * enrollmentDate DATE NOT NULL,
 * student_id BIGINT REFERENCES Student(id),
 * course_id BIGINT REFERENCES Course(id)
 * );
 * <p>
 * INSERT INTO Student (id, name) VALUES (1, 'Alice');
 * INSERT INTO Student (id, name) VALUES (2, 'Bob');
 * INSERT INTO Student (id, name) VALUES (3, 'Charlie');
 * <p>
 * INSERT INTO Course (id, title) VALUES (1, 'Mathematics');
 * INSERT INTO Course (id, title) VALUES (2, 'Physics');
 * INSERT INTO Course (id, title) VALUES (3, 'Chemistry');
 * <p>
 * -- Alice enrolls in Mathematics and Physics
 * INSERT INTO Enrollment (id, enrollmentDate, student_id, course_id) VALUES (1, '2023-10-10', 1, 1);
 * INSERT INTO Enrollment (id, enrollmentDate, student_id, course_id) VALUES (2, '2023-10-09', 1, 2);
 * <p>
 * -- Bob enrolls in Physics
 * INSERT INTO Enrollment (id, enrollmentDate, student_id, course_id) VALUES (3, '2023-09-15', 2, 2);
 * <p>
 * -- Charlie enrolls in Chemistry
 * INSERT INTO Enrollment (id, enrollmentDate, student_id, course_id) VALUES (4, '2023-08-20', 3, 3);
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
            String jpql = """
                    SELECT NEW org.example.dto.CountedEnrollmentForStudent(s.name, count(s))
                    FROM Student s
                    GROUP BY s.name
                    HAVING s.name LIKE '%e'
                    ORDER BY s.name DESC
                    """;

            TypedQuery<CountedEnrollmentForStudent> q =
                    em.createQuery(jpql, CountedEnrollmentForStudent.class);

//            TypedQuery<Student> q = em.createQuery("getAllEnrolledStudents", Student.class);

            q.getResultList().forEach(o -> System.out.println(o));

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
