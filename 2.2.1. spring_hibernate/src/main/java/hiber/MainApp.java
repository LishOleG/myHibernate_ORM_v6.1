package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

import static hiber.model.User.*;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        CarService carService = context.getBean(CarService.class);
        carService.add(new Car("Volo", 940, users.get(0)));
        carService.add(new Car("BMW", 750, users.get(1)));
        carService.add(new Car("Mercedes", 63, users.get(2)));
        carService.add(new Car("Li", 9, users.get(3)));


        List<User> use = userService.listUsers();
        for (User user : use) {
            System.out.println("Id:  " + user.getId());
            System.out.println("First Name:  " + user.getFirstName());
            System.out.println("Last Name:  " + user.getLastName());
            System.out.println("Email:  " + user.getEmail());
            System.out.println("Car:   " + user.getEmpCar());
            System.out.println();
        }

        System.out.println(userService.findByCar("Mercedes", 63));
        context.close();

    }
}
