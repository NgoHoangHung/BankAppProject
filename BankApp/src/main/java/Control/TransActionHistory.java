package Control;

import static Control.CustomerManager.*;

public class TransActionHistory {
    //    xử lí các lệnh xuẩt lịch sử giao dịch
    public static void transactionHistory() {
        if (accSequenceManager.get(getIndexCurrentAccount()).getHistory() == null)
            System.out.print(" ");
        else {
            System.out.println("Lịch sử giao dịch gần nhất:");
            System.out.println(accSequenceManager.get(getIndexCurrentAccount())
                    .getHistory().toString());
        }
        if (accSequenceManager.get(getIndexCurrentAccount()).getMemoryHistory() == null)
        System.out.println("Tất cả giao dịch: ");
        else {
            System.out.println(accSequenceManager.
                    get(getIndexCurrentAccount()).getMemoryHistory());
        }
    }


}
