package View;

import Control.CustomerManager;

import java.util.Scanner;

import static Control.SignIn.identifyInput;

 class ViewSignIn {
    static Scanner scan = new Scanner(System.in);

    //    Xử lí các lệnh đăng nhập
     static boolean viewSignInIO() {
        System.out.println("Nhập vào ID của bạn:");
        int idTmp = Integer.parseInt(scan.nextLine().trim());
        System.out.println("Nhập vào password của bạn:");
        String passwordTmp = scan.nextLine().trim();
        return identifyInput(idTmp, passwordTmp);
    }
}
