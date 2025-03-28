package org.Tema5;

public class Hired extends Person{

    private String jobTitle;

    public Hired(int age, String name, String jobTitle) {
        super(age, name);
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}
