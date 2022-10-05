package Control;


import static Control.CustomerManager.*;

public class SignIn {
//    Xử lí các lệnh đăng nhập
public static boolean identifyInput(int idTmp, String passwordTmp) {
    boolean flagSignin = true;
    boolean flagIdInput = true;
    boolean flagPasswordInput = true;
    while (flagIdInput) {
        if (checkId(idTmp) && checkPassword(passwordTmp)) {

            System.out.println("Xin chào " +
                    accSequenceManager.get(getIndexCurrentAccount()).getName());
            flagIdInput = false;
            break;
        } else {
            System.out.println("Tài khoản không tồn tại");
            System.out.println("Bạn có muốn tiếp tục?");
            System.out.println("Chọn Yes (y) hoặc No (n)");
            String option = scan.nextLine();
            switch (option) {
                case "y": {
                    System.out.println("Nhập vào ID của bạn:");
                    idTmp = Integer.parseInt(scan.nextLine());
                    System.out.println("Nhập vào password của bạn:");
                    passwordTmp = scan.nextLine();
                }
                break;
                case "n":
                default:
                    flagIdInput = false;
                    //dừng việc nhập id pass
                    flagSignin = false;
                    System.out.println("============================================");
                    System.out.println("                                     See You Again                                    ");
                    System.out.println("                                                */");
                    break;
            }
        }
    }//hết hàm while
    return flagSignin;
}
}
