package org.tema8;

import java.util.*;
import java.util.logging.Logger;

public class StudentRepo {

    private final Map<String, Student> students = new HashMap<>();
    public static final Logger logger = Logger.getLogger(StudentRepo.class.getName());

    public void addStudent(Student student) {
        if (students.containsKey(student.getId())) {
            throw new IllegalArgumentException("Student with the same ID already exists.");
        }

        students.put(student.getId(), student);
        logger.info("Added student: " + student);
    }

    public void deleteStudentById(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID field cannot be empty.");
        }

        if (!students.containsKey(id)) {
            throw new NoSuchElementException("Student with this ID not found.");
        }

        students.remove(id);
       logger.info("Deleted student with ID: " + id);
    }

    public List<Student> getStudentsByAge(String ageStr) {
        try {
            int age = Integer.parseInt(ageStr);
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative.");
            }

            return students.values().stream()
                    .filter(s -> s.getAge() == age)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Age must be a number.");
        }
    }

    public List<Student> listStudentsOrderedBy(String field) {
        if (field == null || field.isEmpty()) {
            throw new IllegalArgumentException("Sort field must not be empty");
        }
        return students.values().stream()
                .sorted((s1, s2) -> {
                    switch (field.toLowerCase()) {
                        case "lastname":
                            return s1.getLastName().compareToIgnoreCase(s2.getLastName());
                        case "birthdate":
                            return s1.getDateOfBirth().compareTo(s2.getDateOfBirth());
                        default:
                            throw new IllegalArgumentException("Unsupported sort field: " + field +
                                    ". Make sure you either sort by last name or birthdate.");
                    }
                })
                .toList();
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

}
