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


        UserService userService = new UserService();
        User user = new User("Masha",26);
        userService.saveUser(user);
        Auto ferrari = new Auto("Ferrari");
        ColorPalette studentGfgDetail
                = new ColorPalette();
         studentGfgDetail.ColorPalette("White",true,23);
         ferrari.setColorPalette(studentGfgDetail);
        ferrari.setUser(user);
        user.addAuto(ferrari);
        Auto ford = new Auto("Ford");
        ford.setUser(user);
        user.addAuto(ford);
        userService.updateUser(user);
        System.exit(0);
    }
}
