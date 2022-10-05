package Control;
//Control.SignUp

import Model.AccountCustomer;

import java.util.regex.Pattern;

import static Control.CustomerManager.*;

public class SignUp {
    //    Xử lí các lệnh đăng kí
    public static int generateID() {
        int accountID = (int) (Math.random() * (999999 - 100001 + 1) + (100001));
        while (checkId(accountID))
            accountID = (int) (Math.random() * (999999 - 100001 + 1) + (100001));
        return accountID;
    }

    public static boolean checkRegexPassword(String password) {
        Pattern pUpperCase = Pattern.compile("^.*[A-Z]+.*$");
        Pattern pLowwerCase = Pattern.compile("^.*[a-z]+.*$");
        Pattern pDigit = Pattern.compile("^.*[0-9]+.*$");
        Pattern pSpecial = Pattern.compile("^.*[!@#$%^&*-.,]+.*$");
        Pattern pLengPassword = Pattern.compile("^.{8,}$");
        if (pUpperCase.matcher(password).find() &&
                pLowwerCase.matcher(password).find() &&
                pDigit.matcher(password).find() &&
                pSpecial.matcher(password).find() &&
                pLengPassword.matcher(password).find()) {
            System.out.println("Password hợp lệ");
            return true;
        }
        return false;
    }

    public static int processAge(int age) {
        while (age < 0 || age > 150) {
            try {

                System.out.println("Số tuổi không hợp lệ!");
                System.out.println("Nhập lại tuổi: ");
                age = Integer.parseInt(scan.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Note: Thao tác nhập chứa kí tự không phù hợp.");
                age = Integer.parseInt(scan.nextLine());
            }
        }
        return age;
    }

    public static void creatAccount(String name, int age, String address, int id, String password, int money) {

        accSequenceManager.add(new AccountCustomer(name, age, address, id, password, 0));
        exportDatabase();
    }
}
