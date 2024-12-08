package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car = new Car();
      car.setModel("BMW");
      car.setSeries(5);

      User userWithCar = new User("User4", "Lastname4", "user4@mail.ru", car);

      userService.add(userWithCar);

      User foundUser = userService.findUserByCar("BMW", 5);
      System.out.println(foundUser.getFirstName());

      context.close();
   }
}
