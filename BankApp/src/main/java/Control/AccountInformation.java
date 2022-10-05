package Control;

import static Control.CustomerManager.*;

public class AccountInformation {
//    Xử lí các lệnh về thông tin người dùng
public static void infoAccount() {
    System.out.println(accSequenceManager.get(getIndexCurrentAccount()).toString() +
            "\nSố dư tài khoản: " + accSequenceManager.get(getIndexCurrentAccount()).getMoney() +
            " VNĐ");
}
}
