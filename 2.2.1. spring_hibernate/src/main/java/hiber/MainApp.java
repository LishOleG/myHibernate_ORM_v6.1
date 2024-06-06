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
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        userService.add(new User("User1", "LastName1", "user1@mail.ru"
                , new Car("Volvo", 940)));
        userService.add(new User("User2", "LastName2", "user2@mail.ru"
                , new Car("BMW", 750)));
        userService.add(new User("User3", "LastName3", "user3@mail.ru"
                , new Car("Mercedes", 63)));
        userService.add(new User("User4", "LastName4", "user4@mail.ru"
                , new Car("Li", 9)));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name: " + user.getFirstName());
            System.out.println("Last Name: " + user.getLastName());
            System.out.println("Email: " + user.getEmail());

            System.out.println();
        }

        List<User> use = userService.listUsers();
        for (User user : use) {
            System.out.println("Id:  " + user.getId());
            System.out.println("First Name:  " + user.getFirstName());
            System.out.println("Last Name:  " + user.getLastName());
            System.out.println("Email:  " + user.getEmail());
            System.out.println("useCar: " + user.getCar());
            System.out.println();
        }
        System.out.println(userService.findByCar("Mercedes", 63));
        context.close();

    }
}
