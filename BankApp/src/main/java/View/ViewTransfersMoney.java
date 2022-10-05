package View;

import Model.AccountCustomer;

import java.util.Scanner;

import static Control.CustomerManager.checkIdDestination;
import static Control.TransfersMoney.transferMoney;

class ViewTransfersMoney {
    static Scanner scan = new Scanner(System.in);

    //    Xử lí các lệnh chuyển tiền
    static void viewTransfersMoney() throws InterruptedException {
        System.out.println("Nhập số tài khoản cần chuyển: ");
        int id = Integer.parseInt(scan.nextLine());
        while (!checkIdDestination(id)) {
            System.out.println("tài khoản không tồn tại: ");
            System.out.println("Nhập lại số tài khoản cần chuyển: ");
            id = Integer.parseInt(scan.nextLine());
        }
        System.out.println("Nhập vào số tiền cần chuyển:");
        int transfersMoneyInput = Integer.parseInt(scan.nextLine());
        while (transfersMoneyInput <= 0) {
            System.out.println("Số tiền chuyển phải lớn hơn 0");
            System.out.println("Quý khách vui lòng nhập lại số tiền muốn chuyển");
            transfersMoneyInput = Integer.parseInt(scan.nextLine().trim());
        }
            transferMoney(id, transfersMoneyInput);
    }
}
