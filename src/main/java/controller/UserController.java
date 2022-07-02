package controller;

import entity.User;
import payload.Result;
import payload.UserDto;
import service.UserService;

import java.util.Scanner;

public class UserController {
    static UserService userService=new UserService();
    public Result registorUser(Scanner scanner) {
        scanner=new Scanner(System.in);
        System.out.print("Ismingizni kiriting: ");
        String name = scanner.nextLine();
        System.out.print("Emailni kiriting: ");
        String email = scanner.nextLine();
        System.out.print("Parolni kiriting: ");
        String password = scanner.nextLine();
        System.out.print("Parolni qayta kiriting: ");
        String prePassword = scanner.nextLine();
        System.out.print("Address id ni kiriting: ");
        scanner=new Scanner(System.in);
        int addressId = scanner.nextInt();
        UserDto userDto=new UserDto(name,email,password,prePassword,addressId);
        return userService.saveUser(userDto);


    }
}
