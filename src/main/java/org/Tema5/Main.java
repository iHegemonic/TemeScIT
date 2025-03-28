package org.Tema5;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        TreeSet<Person> peopleByName = new TreeSet<>(new NameComparator());
        TreeSet<Person> peopleByAge = new TreeSet<>(new AgeComparator());


        Person p1 = new Student(22, "Alice", "UBB");
        Person p2 = new Hired(30, "Relu", "Sculptor");
        Person p3 = new Unemployed(25, "Cici");
        Person p4 = new Student(27, "David", "UAIC");

        peopleByName.add(p1);
        peopleByName.add(p2);
        peopleByName.add(p3);
        peopleByName.add(p4);

        System.out.println("People sorted by name: ");
        for (Person p : peopleByName) {
            System.out.println(p);
        }

        peopleByAge.addAll(peopleByName);
        System.out.println("\nPeople sorted by age: ");
        for (Person p : peopleByAge) {
            System.out.println(p);
        }

        HashMap<Person, List<Hobby>> hobbiesMap = new HashMap<>();

        Country romania = new Country("Romania");
        Country usa = new Country("USA");

        Address address1 = new Address("Strada Noua", romania);
        Address address2 = new Address("First Street", usa);

        List<Address> cyclingLocations = new ArrayList<>();
        cyclingLocations.add(address1);
        cyclingLocations.add(address2);
        Hobby cycling = new Hobby("Cycling", 3, cyclingLocations);

        List<Address> swimmingLocations = new ArrayList<>();
        swimmingLocations.add(address2);
        Hobby swimming = new Hobby("Swimming", 2, swimmingLocations);

        List<Hobby> hobbiesForP1 = new ArrayList<>();
        hobbiesForP1.add(cycling);
        hobbiesForP1.add(swimming);
        hobbiesMap.put(p1, hobbiesForP1);

        List<Hobby> hobbiesForP2 = new ArrayList<>();
        hobbiesForP2.add(swimming);
        hobbiesMap.put(p2, hobbiesForP2);

        Person targetPerson = p2;
        System.out.println("\nHobbies for " + targetPerson.getName() + ":");
        if (hobbiesMap.containsKey(targetPerson)) {
            List<Hobby> hobbies = hobbiesMap.get(targetPerson);
            for (Hobby hobby : hobbies) {
                System.out.println(hobby.getName() + " can be practiced in: ");
                for (Address address : hobby.getLocations()) {
                    System.out.println(address.getCountry().getName() + " ");
                }
                System.out.println();
            }

        } else {
            System.out.println("No hobbies found");
        }


    }
}