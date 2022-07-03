import controller.UserController;
import entity.Address;
import entity.Role;
import entity.User;
import payload.Result;
import repository.UserRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static UserController userController = new UserController();
    static UserRepository userRepository = new UserRepository();

    public static void main(String[] args) {
        User user = new User(
                userRepository.getUserSet().size() + 1,
                "Elyorbek",
                "bek@gmail.com",
                "123",
                1500.0,
                new Address(),
                Timestamp.valueOf(LocalDateTime.now()),
                Role.DIRECTOR
        );
        Set<User> userSet = userRepository.getUserSet();
        userSet.add(user);
        user = new User(
                userRepository.getUserSet().size() + 1,
                "Sharobiddin",
                "toy@gmail.com",
                "456",
                1000.0,
                new Address(),
                Timestamp.valueOf(LocalDateTime.now()),
                Role.USER
        );
        userSet.add(user);
        boolean active = true;
        while (active) {
            System.out.println("1.Sign In");
            System.out.println("2.Registor");
            System.out.println("3.Exit");
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    userController.logIn(scanner);
                case 2:
                    Result result = userController.registorUser(scanner);
                    if (result.isSucces())
                        System.out.println(result.getMessage());
                    if (!result.isSucces() && result.getObject() == null)
                        System.out.println(result.getMessage());
                    else
                        System.out.println(result.getObject());
                case 3:
                    active = false;
            }

        }
    }
}
