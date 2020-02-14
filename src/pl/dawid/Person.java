package pl.dawid;

import java.util.Objects;

enum Gender{
    MALE,FEMALE
}

public class Person {
    private String name;
    private Gender gender;
    private int count;

    public Person(String name, Gender gender, int count) {
        this.name = name;
        this.gender = gender;
        this.count = count;
    }

    public Person(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name= '" + name +
                ", gender= " + gender +
                ", count= " + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) &&
                gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender);
    }
}
