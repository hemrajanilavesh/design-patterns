package com.lavesh.design.patterns.structural.criteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Person {

    String name;
    String gender;
    String maritalStatus;

    public Person(String name, String gender, String maritalStatus) {
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return name.equals(person.name) &&
                gender.equals(person.gender) &&
                maritalStatus.equals(person.maritalStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, maritalStatus);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                '}';
    }
}

interface Criteria {
    List<Person> filterBasedOnCriteria(List<Person> persons);
}

class MaleCriteria implements Criteria {
    @Override
    public List<Person> filterBasedOnCriteria(List<Person> persons) {
        List<Person> filteredPersons = new ArrayList<>(persons.size());
        for (Person person :
                persons) {
            if (person.gender.equalsIgnoreCase("MALE")) {
                filteredPersons.add(person);
            }

        }
        return filteredPersons;
    }
}

class FemaleCriteria implements Criteria {
    @Override
    public List<Person> filterBasedOnCriteria(List<Person> persons) {
        List<Person> filteredPersons = new ArrayList<>(persons.size());
        for (Person person :
                persons) {
            if (person.gender.equalsIgnoreCase("FEMALE")) {
                filteredPersons.add(person);
            }

        }
        return filteredPersons;
    }
}

class SingleCriteria implements Criteria {
    @Override
    public List<Person> filterBasedOnCriteria(List<Person> persons) {
        List<Person> filteredPersons = new ArrayList<>(persons.size());
        for (Person person :
                persons) {
            if (person.maritalStatus.equalsIgnoreCase("SINGLE")) {
                filteredPersons.add(person);
            }

        }
        return filteredPersons;
    }
}

class AndCriteria implements Criteria {

    Criteria firstCriteria;
    Criteria secondCriteria;

    public AndCriteria(Criteria firstCriteria, Criteria secondCriteria) {
        this.firstCriteria = firstCriteria;
        this.secondCriteria = secondCriteria;
    }

    @Override
    public List<Person> filterBasedOnCriteria(List<Person> persons) {
        List<Person> firstCriteriaResult = firstCriteria.filterBasedOnCriteria(persons);
        return secondCriteria.filterBasedOnCriteria(firstCriteriaResult);
    }
}

class OrCriteria implements Criteria {

    Criteria primaryCriteria;
    Criteria otherCriteria;

    public OrCriteria(Criteria primaryCriteria, Criteria otherCriteria) {
        this.primaryCriteria = primaryCriteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> filterBasedOnCriteria(List<Person> persons) {
        List<Person> primaryResults = primaryCriteria.filterBasedOnCriteria(persons);
        List<Person> secondaryResults = otherCriteria.filterBasedOnCriteria(persons);

        for (Person person : secondaryResults) {
            if (!primaryResults.contains(person)) {
                 primaryResults.add(person);
            }
        }

        return primaryResults;
    }
}

public class CriteriaDesignPatternDemo {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();

        persons.add(new Person("Robert","Male", "Single"));
        persons.add(new Person("John", "Male", "Married"));
        persons.add(new Person("Laura", "Female", "Married"));
        persons.add(new Person("Diana", "Female", "Single"));
        persons.add(new Person("Mike", "Male", "Single"));
        persons.add(new Person("Bobby", "Male", "Single"));

        Criteria male = new MaleCriteria();
        Criteria female = new FemaleCriteria();
        Criteria single = new SingleCriteria();
        Criteria singleMale = new AndCriteria(single, male);
        Criteria singleOrFemale = new OrCriteria(single, female);

        System.out.println("Males: ");
        printPersons(male.filterBasedOnCriteria(persons));

        System.out.println("\nFemales: ");
        printPersons(female.filterBasedOnCriteria(persons));

        System.out.println("\nSingle Males: ");
        printPersons(singleMale.filterBasedOnCriteria(persons));

        System.out.println("\nSingle Or Females: ");
        printPersons(singleOrFemale.filterBasedOnCriteria(persons));
    }

    public static void printPersons(List<Person> persons){

        for (Person person : persons) {
            System.out.println("Person : [ Name : " + person.getName() + ", Gender : " + person.getGender() + ", Marital Status : " + person.getMaritalStatus() + " ]");
        }
    }
}

