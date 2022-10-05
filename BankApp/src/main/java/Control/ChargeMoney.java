package Control;

import Model.AccountCustomer;
import Model.History;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static Control.CustomerManager.*;

public class ChargeMoney {
    //    Xử lí các lệnh nạp tiền
    public static void currrentAccountCharge(int moneyTmp) throws InterruptedException {
        AccountCustomer acctmp = accSequenceManager.get(getIndexCurrentAccount());
        while (true) {
            if (acctmp.getMoney() < 50000&&moneyTmp<50000) {
                System.out.println("[Lần đầu nạp tiền phải tối thiểu 50000 VNĐ]");
                System.out.println("Bạn có muốn tiếp tục?");
                System.out.println("Ấn y(Yes) hoặc n(No)");
                String checkOption = scan.nextLine();
                switch (checkOption) {
                    case ("y"):
                        System.out.println("Nhập số tiền cần nạp:");
                        moneyTmp = Integer.parseInt(scan.nextLine());
                        break;
                    case ("n"):
                    default:
                        System.out.println("Nạp tiền không thành công");
                        break;
                }
            } else {
                acctmp.setMoney(acctmp.getMoney() + moneyTmp);
                System.out.println("Hệ thống đang xử lí:");
                for (char s : "[#################################]".toCharArray()) {
                    System.out.print(s);
                    TimeUnit.MILLISECONDS.sleep(20);
                }
                System.out.println("\n[Done]");
                TimeUnit.SECONDS.sleep(1);
                System.out.println();
                System.out.println("Nạp thành công");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Số tiền trong tài khoản là: " + acctmp.getMoney());
                System.out.println();
                //    phần tạo lịch sử
                Date creatAt = new Date();
                History history = new History(creatAt, "Nạp tiền", "Đã nạp thành công", moneyTmp);
                acctmp.setHistory(history);
                acctmp.setMemoryHistory(acctmp.getMemoryHistory() + "\n" + history.historyNote(creatAt, "Nạp tiền", "Đã nạp thành công", moneyTmp));

                //phần lưu lại database
                exportDatabase();
                importDatabase();
                break;
            }
        }
    }
}

