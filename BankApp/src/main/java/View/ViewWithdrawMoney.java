package View;

import java.util.Scanner;

import static Control.WithdrawMoney.currrentAccountWithdrawMoney;

class ViewWithdrawMoney {
  static Scanner scan =new Scanner(System.in);
//    Xử lí các lệnh rút tiền
static void viewWithdrawMoney() throws InterruptedException {
 System.out.println("Nhập vào số tiền muốn rút:");
 int withdrawMoneyInput = Integer.parseInt(scan.nextLine().trim());
 while (withdrawMoneyInput<=0){
     System.out.println("Số tiền rút phải lớn hơn 0");
     System.out.println("Quý khách vui lòng nhập lại số tiền muốn rút");
     withdrawMoneyInput = Integer.parseInt(scan.nextLine().trim());
 }
 currrentAccountWithdrawMoney(withdrawMoneyInput);
}
}
