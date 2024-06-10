package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

import static hiber.model.User.*;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Adam", "LastName1", "user1@mail.ru");
        User user2 = new User("Alice", "LastName2", "user2@mail.ru");
        User user3 = new User("Oleg", "LastName3", "user3@mail.ru");
        User user4 = new User("Dany", "LastName4", "user4@mail.ru");
        User user5 = new User("Olga", "LastName5", "user5@mail.ru");

        Car car1 = (new Car("Volvo", 940));
        Car car2 = (new Car("BMW", 750));
        Car car3 = (new Car("Mercedes", 63));
        Car car4 = (new Car("Li", 9));
        Car car5 = (new Car("Camry", 70));

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


////////////////////////////////////

        /*
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
            System.out.println("Id: " + user.getId());
            System.out.println("First Name: " + user.getFirstName());
            System.out.println("Last Name: " + user.getLastName());
            System.out.println("Email: " + user.getEmail());

            System.out.println(user);
            System.out.println();
        }

        CarService carService = context.getBean(CarService.class);

        carService.add(new Car("Volvo", 940));
        carService.add(new Car("BMW", 750));
        carService.add(new Car("Mercedes", 63));
        carService.add(new Car("Li", 9));
        carService.add(new Car("Camry", 70));

        List<Car> cars = carService.listCars();
        for (Car car : cars) {
            System.out.println("Id: " + car.getId());
            System.out.println("model: " + car.getModel());
            System.out.println("series: " + car.getSeries());

            System.out.println();
            System.out.println(car);
            System.out.println();
        }

         */



