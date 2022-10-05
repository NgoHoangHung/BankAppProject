package Control;

import Model.AccountCustomer;
import Model.History;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static Control.CustomerManager.*;

public class TransfersMoney {
    static Scanner scan = new Scanner(System.in);

    //    Xử lí các lệnh chuyển tiền
    public static void transferMoney(int id, int money) throws InterruptedException {
        int indexTmp = -1;
        AccountCustomer acctmp = accSequenceManager.get(getIndexCurrentAccount());
        for (AccountCustomer obj : accSequenceManager) {
            if (obj.getIdentify() == id )
                indexTmp = accSequenceManager.indexOf(obj);
        }

            System.out.println("Nhập nội dung chuyển tiền: ");
            String say = scan.nextLine();
//            for (; ; ) {
                if (acctmp.getMoney() - money >= 50000) {
                    accSequenceManager.get(indexTmp).setMoney(accSequenceManager.get(indexTmp).getMoney() + money);
                    acctmp.setMoney(acctmp.getMoney() - money);
                    System.out.println("Hệ thống đang xử lí:");
                    for (char s : "[#################################]".toCharArray()) {
                        System.out.print(s);
                        TimeUnit.MILLISECONDS.sleep(20);
                    }
                    System.out.println("\n[Done]");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println();
                    System.out.println("Chuyển thành công.");
                    System.out.println("Số dư còn: " + acctmp.getMoney() + " VNĐ");
//Phần ghi lại lịch sử
                    Date creatAt = new Date();
                    History history = new History(creatAt, "Chuyển tiền cho: " +
                            accSequenceManager.get(indexTmp).getName() +
                            "\nSố tài khoản: " + accSequenceManager.get(indexTmp).getIdentify() + "."
                            , say, money);
                    acctmp.setHistory(history);

                    String historyNoteObj = history.historyNote(creatAt, "Chuyển tiền cho: " +
                            accSequenceManager.get(indexTmp).getName() +
                            "\nSố tài khoản: " + accSequenceManager.get(indexTmp).getIdentify() + ".", say, money);
                    acctmp.setMemoryHistory(acctmp.getMemoryHistory() + "\n" + historyNoteObj);


                    //Phần thông báo cho người nhận.

                    History history1 = new History(creatAt, "Nhận tiền từ " +
                            acctmp.getName() + "\n Số tài khoản:" +
                            acctmp.getIdentify() + ".", say, money);
                    accSequenceManager.get(indexTmp).setHistory(history1);
                    String historyNoteObj1 = history.historyNote(creatAt, "Nhận tiền từ " +
                            acctmp.getName() + "\n Số tài khoản:" +
                            acctmp.getIdentify() + ".", say, money);

                    accSequenceManager.get(indexTmp).setMemoryHistory
                            (accSequenceManager.get(indexTmp).getMemoryHistory() + "\n" + historyNoteObj1);

                    //phần ghi lại cơ sở dữ liệu
                    exportDatabase();
                    importDatabase();
//                    break; // dừng chương trình khi đầu vào ok
                } else
                        System.out.println("số dư không đủ");

    }
}