package AQA.Task6_7;

import javax.persistence.*;

@Entity
@Table(name = "friends")
public class Friends {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "name")
    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person")
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address")
    private Address address;


    public Friends(String name) {
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String model) {
        this.name = model;
    }


    public Person getPerson() {
        return person;
    }
    public Address getAddress()
    {
        return address;
    }

    public void
    setAddress(Address address)
    {
        this.address = address;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return " " + name;
    }
}