import controller.UserController;
import entity.User;
import payload.Result;

import java.util.Scanner;

public class Main {
    static Scanner scanner=new Scanner(System.in);
    static User user=new User();
    static UserController userController=new UserController();
    public static void main(String[] args) {
        boolean active=true;
        while(active){
            System.out.println("1.Sign In");
            System.out.println("2.Registor");
            System.out.println("3.Exit");
            int num = scanner.nextInt();
            switch (num){
                case 1:

                case 2:
                    Result result=userController.registorUser(scanner);
                    if(result.isSucces())
                        System.out.println("User muaffaqiyatli qo'shildi");
                    if (!result.isSucces()&&result.getObject()==null)
                        System.out.println(result.getMessage());
                    else
                        System.out.println(result.getObject());

                case 3:
                    active=false;
            }

        }
    }
}
