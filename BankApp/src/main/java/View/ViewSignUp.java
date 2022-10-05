package View;

import Control.SignUp;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static Control.SignUp.*;

class ViewSignUp {
    //    Xử lí các lệnh đăng kí
    static Scanner scan = new Scanner(System.in);

    static void viewSignUpIO() throws InterruptedException {

        System.out.println("======================================================");
        System.out.println("                                                       Đăng kí                                                      ");
        System.out.println("======================================================");
        int id = SignUp.generateID();
        System.out.println("ID của bạn sẽ là \n" + id);
        System.out.printf("Nhập password ứng với ID :%d\n", id);
        String password = scan.nextLine();
        while (!checkRegexPassword(password)) {
            System.out.println("Sai định dạng" +
                    "\npassword phải có ít nhất 1 kí tự viết hoa trở lên" +
                    "\npassword phải có ít nhất 1 kí tự viết thường trở lên" +
                    "\n password phải có 1 kí tự số từ 0 - 9 trở lên" +
                    "\npassword phải có 1 kí tự đặc biệt như !@#$%^&*-., trở lên" +
                    "\npassword phải có 8 kí tự trở lên");
            System.out.println("Nhập lại pass");
            password = scan.nextLine();

        }
        System.out.println("Nhập tên");
        String name = scan.nextLine();
        System.out.println("Nhập tuổi");
        int age = Integer.parseInt(scan.nextLine());
        age = processAge(age);
        System.out.println("Nhập địa chỉ");
        String address = scan.nextLine();
        System.out.println("Hệ thống đang xử lí:");
        for (char s : "[#####                                 ]25%\n[##########                      ]50%\n[###############           ]75%\n[####################]100%".toCharArray()) {
            System.out.print(s);
            TimeUnit.MILLISECONDS.sleep(20);
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println();
        System.out.println("Đăng kí thành công!");
        System.out.println();
        creatAccount(name, age, address, id, password, 0);

    }
}


