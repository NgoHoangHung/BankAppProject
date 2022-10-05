package View;

import java.util.Scanner;

import static Control.ChargeMoney.currrentAccountCharge;

class ViewChargeMoney {
    static Scanner scan = new Scanner(System.in);

    //    Xử lí các lệnh nạp tiền
    static void viewChargeMonney() throws InterruptedException {
        boolean flag = true;
        boolean flagInput = true;
        int chargeMoneyInput = 0;
        while (flag) {
                try {
                    System.out.println("Nhập vào số tiền cần nạp:");
                    chargeMoneyInput = Integer.parseInt(scan.nextLine());
                    flag = false;
                } catch (Exception e){
                    System.out.println("[Nhập vào sai kiểu]");
                    System.out.println("[Xin hãy nhập lại]");
                }
        }
        currrentAccountCharge(chargeMoneyInput);
    }
}
