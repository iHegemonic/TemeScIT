import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.tema8.Student;
import org.tema8.StudentRepo;

import java.time.LocalDate;
import java.util.List;

public class StudentRepositoryTest {

    private StudentRepo repository;

    @BeforeEach
    public void setUp() {
        repository = new StudentRepo();
    }

@Test
    public void testAddValidStudent() {
    Student student = new Student("Relu", "Motanelu", LocalDate.of(1999, 1,1),
            "Male", "1");
        repository.addStudent(student);
    Assertions.assertEquals(1, repository.getAllStudents().size());

}

@Test
    public void testAddInvalidStudent() {
    Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        new Student("", "Genovie", LocalDate.of(2004,2,13),
                "male", "2");
    });
    Assertions.assertEquals("You must have a first name.", e.getMessage());
}

@Test
    public void testDeleteExistingStudent() {
    Student student = new Student("Gelu", "Rapidelu", LocalDate.of(2000,12,1),
            "male", "3");

    repository.addStudent(student);
    repository.deleteStudentById("3");
    Assertions.assertTrue(repository.getAllStudents().isEmpty());
}

@Test
    public void testDeleteStudentWithEmptyId() {
    Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        repository.deleteStudentById("");
    });
    Assertions.assertEquals("ID field cannot be empty.", e.getMessage());
}

@Test
    public void testRetrieveByAge() {
    Student student = new Student("Alice", "Wonder", LocalDate.of(1998,4,15),
            "female",
            "4");
    repository.addStudent(student);
    List<Student> agelist = repository.getStudentsByAge("26");
    agelist.forEach(System.out::println);
}

@Test
    public void testRetrieveByInvalidAgeFormat() {
        Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            repository.getStudentsByAge("Twenty");
        });
        Assertions.assertEquals("Age must be a number.", e.getMessage());
}

@Test
    public void testListStudentsByLastName() {
        Student a = new Student("Mihai", "Ionescu", LocalDate.of(1999,2,2),
                "Male", "5");
        Student b = new Student("Alex", "Popescu", LocalDate.of(2000,1,1),
                "Male","6");

        repository.addStudent(a);
        repository.addStudent(b);

        List<Student> sorted = repository.listStudentsOrderedBy("lastname");
        Assertions.assertEquals("Ionescu", sorted.get(0).getLastName());
        Assertions.assertEquals("Popescu", sorted.get(1).getLastName());
}

@Test
    public void testListStudentsByBirthDate() {
        Student old = new Student("Old", "Student", LocalDate.of(1983, 1, 1),
                "Female", "7");
        Student young = new Student("Young", "Student",
                LocalDate.of(2004, 2, 2), "male", "8");

        repository.addStudent(old);
        repository.addStudent(young);

        List<Student> sorted = repository.listStudentsOrderedBy("birthdate");


        Assertions.assertEquals("Old", sorted.get(0).getFirstName());
        Assertions.assertEquals("Young", sorted.get(1).getFirstName());
}

@Test
    public void testSortFieldEmpty() {
        Exception e = Assertions.assertThrows(IllegalArgumentException.class,() -> {
            repository.listStudentsOrderedBy("");
        });
        Assertions.assertEquals("Sort field must not be empty", e.getMessage());
        }
}


