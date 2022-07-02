package controller;

import entity.User;
import payload.Result;
import payload.UserDto;
import service.UserService;

import java.util.Scanner;

public class UserController {
    static UserService userService = new UserService();

    public Result registorUser(Scanner scanner) {
        scanner = new Scanner(System.in);
        System.out.print("Ismingizni kiriting: ");
        String name = scanner.nextLine();
        System.out.print("Emailni kiriting: ");
        String email = scanner.nextLine();
        System.out.print("Parolni kiriting: ");
        String password = scanner.nextLine();
        System.out.print("Parolni qayta kiriting: ");
        String prePassword = scanner.nextLine();
        System.out.print("Address id ni kiriting: ");
        scanner = new Scanner(System.in);
        int addressId = scanner.nextInt();
        UserDto userDto = new UserDto(name, email, password, prePassword, addressId);
        return userService.saveUser(userDto);


    }

    public void logIn(Scanner scanner) {
        scanner = new Scanner(System.in);
        int count = 0;
        while (count < 3){
            System.out.print("Iltimos emailingizni kiriting: ");
            String email = scanner.nextLine();
            System.out.print("Iltimos parolni kiriting: ");
            String password = scanner.nextLine();
            UserDto userDto=new UserDto(email,password);
            if (userService.equalsUser(userDto)){
                if (userService.equalsDirector(userDto))
                    directorMenu();
                if (userService.equalsDriver(userDto))
                    driverMenu();
                if (userService.equalsVendor(userDto))
                    vendorMenu();
//                if (userService.equalsUserRole(userDto))
//                    userMenu();

            }else {

                if (count==1)
                    System.err.println("Sizda Oxirgi Imkoniyat. Agar parol yoki loginda xatolik bo'lsa user 1 soatga qulflanadi!");
                System.err.println("Login yoki Parolda xatolik");
                // shu yerda Threedning sleep methodini so'rash kerak

            }
            count++;
        }
    }

    private void vendorMenu() {

    }

    private void driverMenu() {
        System.out.println("Bu yerga nima yozishni bilmadim :-)");
    }

    private void directorMenu() {
        System.out.println("1.Kirim maxsulotlar ro'yxati");
        System.out.println("2.Kunlik savdo");
        System.out.println("3.Yaroqlilik muddati yaqin qolganlar");
        System.out.println("4.Kunlik foyda miqdori");
    }
}
