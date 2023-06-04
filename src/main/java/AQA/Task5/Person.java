package AQA.Task5;

import java.io.Serializable;
import java.util.HashMap;

public class Person implements Serializable,Comparable<Person> {
    private String name;
    private Boolean isStudent;
    private HashMap<String, String> address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStudent() {
        return isStudent;
    }

    public void setStudent(Boolean student) {
        isStudent = student;
    }

    public HashMap<String, String> getAddress() {
        return address;
    }

    public void setAddress(HashMap<String, String> address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", isStudent=" + isStudent +
                ", address=" + address +
                '}';
    }

    public Person() {
    }

    @Override
    public int compareTo(Person o) {
        Person o1 =(Person)this;
        Person o2 =(Person)o;
        return o1.getName().compareTo(o2.getName());
    }
}
