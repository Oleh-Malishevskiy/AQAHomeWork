package AQA.Task6_7;


import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

//        task6:
//        Install MySQL server
//        Make at least two tables (Entities from previous task or any additional if need)
//        Make models for those Entities (from Task_5)
//        Setup Hibernate for those Entities and local DB
//        Check basic CRUD (create, read, update, delete the BD records using Hibernate)
//        Generate few rows into all tabled
//        task7:
//        Implement OneToOne, OneToMany, ManyToMany relations in your models from previous task. (add some additional tables if need)
//        Test it by CRUD.


        PersonService personService = new PersonService();
        Person person = new Person("Yevgeniy",20);

       Friends friends = new Friends("Ivan");
        Address address = new Address("789 Oak St","Los Angeles","CA");
        friends.setAddress(address);
       friends.setPerson(person);
        person.addPerson(friends);
        personService.savePerson(person);
        Friends friends1 = new Friends("Alex");
        friends1.setPerson(person);
        person.addPerson(friends1);
      personService.updatePerson(person);
      personService.findAllPersons();
       personService.deletePerson(person);
        System.exit(0);
    }
}
