package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static hiber.model.User.*;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);

        User user1 = new User("Adam", "Lish1", "user1@mail.ru");
        User user2 = new User("Alice", "Lish2", "user2@mail.ru");
        User user3 = new User("Oleg", "Lish3", "user3@mail.ru");
        User user4 = new User("Danya", "Lish4", "user4@mail.ru");
        User user5 = new User("Olga", "Lish5", "user5@mail.ru");

        userService.listUsers().add(user1);
        userService.listUsers().add(user2);
        userService.listUsers().add(user3);
        userService.listUsers().add(user4);
        userService.listUsers().add(user5);

        List<User> users_DB = userService.getListUsers();
        for (User user : users_DB) {

            System.out.println(user.toString());
        }

        Car car1 = new Car("Volvo", 940);
        Car car2 = new Car("BMW", 750);
        Car car3 = new Car("Mercedes", 63);
        Car car4 = new Car("Li", 9);
        Car car5 = new Car("Camry", 70);

        carService.listCars().add(car1);
        carService.listCars().add(car2);
        carService.listCars().add(car3);
        carService.listCars().add(car4);
        carService.listCars().add(car5);

        List<Car> car_DB = carService.getListCars();
        for (Car car : car_DB) {

            System.out.println(car.toString());
        }

        userService.add(user1.setCar(car1).setCarUser(user1));
        userService.add(user2.setCar(car2).setCarUser(user2));
        userService.add(user3.setCar(car3).setCarUser(user3));
        userService.add(user4.setCar(car4).setCarUser(user4));
        userService.add(user5.setCar(car5).setCarUser(user5));

        for (User user : userService.listUsers()) {
            System.out.println(user + " " + user.getCar());
        }

        System.out.println(userService.findByCar("Mercedes", 63));


        context.close();

    }
}



