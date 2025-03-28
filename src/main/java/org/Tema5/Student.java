package org.Tema5;

public class Student extends Person {

    private String university;

    public Student(int age, String name, String university) {
        super(age, name);
        this.university = university;
    }

    public String getUniversity() {
        return university;
    }
}
