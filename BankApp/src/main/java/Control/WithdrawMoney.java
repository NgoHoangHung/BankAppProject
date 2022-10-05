package Control;

import Model.AccountCustomer;
import Model.History;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static Control.CustomerManager.*;

public class WithdrawMoney {
//    Xử lí các lệnh rút tiền
public static void currrentAccountWithdrawMoney(int moneyTmp) throws InterruptedException {
     AccountCustomer acctmp = accSequenceManager.get(getIndexCurrentAccount());
    if (acctmp.getMoney() - moneyTmp >= 50000) {
        acctmp.setMoney(acctmp.getMoney() - moneyTmp);
        System.out.println("Hệ thống đang xử lí:");
        for (char s : "[#################################]".toCharArray()) {
            System.out.print(s);
            TimeUnit.MILLISECONDS.sleep(20);
        }
        System.out.println("\n[Done]");
        TimeUnit.SECONDS.sleep(1);
        System.out.println();
        System.out.println("Rút tiền thành công.");
        System.out.println("Số tiền trong tài khoản là: " + acctmp.getMoney());

//phần ghi lại lịch sử
        Date creatAt = new Date();
        History history = new History(creatAt, "Rút tiền"
                ,"Đã rút", moneyTmp);
        acctmp.setHistory(history);
        String historyNoteObj = history.historyNote(creatAt, "Rút tiền", "Đã rút", moneyTmp);
        acctmp.setMemoryHistory(acctmp.getMemoryHistory() + historyNoteObj);

        exportDatabase();
        importDatabase();
    } else {
        System.out.println("Số dư không đủ");
    }
}
}
