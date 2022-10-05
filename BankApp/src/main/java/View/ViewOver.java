package View;

import Control.CustomerManager;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static Control.CustomerManager.*;
import static View.ViewAccountInformation.viewInfoAccount;
import static View.ViewChargeMoney.viewChargeMonney;
import static View.ViewSignIn.viewSignInIO;
import static View.ViewSignUp.viewSignUpIO;
import static View.ViewTransActionHistory.viewTransactionHistory;
import static View.ViewTransfersMoney.viewTransfersMoney;
import static View.ViewWithdrawMoney.viewWithdrawMoney;

class ViewOver {
    static Scanner scan = new Scanner(System.in);
    static CustomerManager Obj = new CustomerManager();

    static void processMain() throws InterruptedException {
        importDatabase();
        boolean flagMain = true;
        while (flagMain) {
            showMainMenu();
            try {
                int funtionMain = Integer.parseInt(scan.nextLine());
                switch (funtionMain) {
                    //lựa chọn đăng kí
                    case 1:
                        viewSignUpIO();
                        break;
                    //lựa chọn đăng nhập cho admin và user
                    case 2: {
                        if (viewSignInIO()) {
                            boolean flagMainSignIn = true;
                            while (flagMainSignIn) {
                                viewCustomerOption();
                                try {
                                    int funtionSignIn = Integer.parseInt(scan.nextLine());
                                    switch (funtionSignIn) {
                                        case 1:
                                            viewChargeMonney();
                                            break;
                                        case 2:
                                            viewTransfersMoney();
                                            break;
                                        case 3:
                                            viewWithdrawMoney();
                                            break;
                                        case 4:
                                            viewTransactionHistory();
                                            break;
                                        case 5:
                                            viewInfoAccount();
                                            break;
                                        case 6: {
                                            flagMainSignIn = false;
                                            viewEnd();
                                            break;
                                        }
                                        default:
                                            System.out.println("Nhập sai lựa chọn:");
                                            break;
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Tác vụ chưa hoàn thành");
                                }
                                TimeUnit.SECONDS.sleep(1);
                            }
                        }
                    }
                    break;
                    case 3:
                        flagMain = false;
                        viewEnd();
                        break;
                    default:
                        System.out.println("Nhập sai lựa chọn:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Phải nhập đúng lựa chọn");
            }
            TimeUnit.SECONDS.sleep(1);
        }
    }

    static void showMainMenu() {
        System.out.println("======================================================");
        System.out.println("                               TechMaster Bank xin chào quý khách                       ");
        System.out.println("======================================================");
        System.out.println("                                            [1] Đăng kí tài khoản                                        ");
        System.out.println("                                            [2] Đăng nhập                                                    ");
        System.out.println("                                            [3] Thoát                                                             ");
        System.out.println("[Nhập vào lựa chọn:]                                                                                  ");
        System.out.println("======================================================");
    }

    static void showAccountOption() {
        System.out.println("======================================================");
        System.out.println("                                             [Loại tài khoản:]                                              ");
        System.out.println("======================================================");
        System.out.println("                                             [1] Admin                                                           ");
        System.out.println("                                             [2] Customer                                                     ");
        System.out.println("[Nhập vào lựa chọn:]                                                                                   ");
        System.out.println("======================================================");
    }

    static void viewEnd() {
        System.out.println("======================================================");
        System.out.println("                                     [See You Again]                                                    ");
        System.out.println("                                                */                                                                 ");
    }

    static void viewAdmin() {
        System.out.println("======================================================");
        System.out.println("                                                  Admin                                                            ");
        System.out.println("======================================================");
        System.out.println("                                      [Lựa chọn:]                                                              ");
        System.out.println("                                      [1] Phản hồi của khách hàng                                ");
        System.out.println("                                      [2] Xóa tài khoản khách hàng                               ");
        System.out.println("                                      [3] Sửa tài khoản khách hàng                               ");
        System.out.println("                                      [4] Danh sách khách hàng                                     ");
        System.out.println("                                      [5] Đăng xuất                                                           ");
        System.out.println("[Nhập vào lựa chọn:]                                                                                   ");
        System.out.println("======================================================");
    }

    static void viewCustomerFeedback() {
        System.out.println("Dịch vụ phản hồi: ");
        String feedback = scan.nextLine();
        // truyền hàm xử lí
    }

    static void viewProcessedFeedback() {
        System.out.println("======================================================");
        System.out.println("                                                  Feedback                                                       ");
        System.out.println("======================================================");
        System.out.println("                                          [1] Feedback đã xử lí                                          ");
        System.out.println("                                          [2] Feedback chưa xử lí                                      ");
        System.out.println("======================================================");
    }


    static void viewCustomerOption() {
        Date date = new Date();
        System.out.println("============ " + "[" + String.valueOf(date) + "]" + " ==============");
        infoCustomer();
        System.out.println("Số dư khả dụng: ************** <o>                                                    ");
        System.out.println("======================================================");
        System.out.println("                                      [Lựa chọn:]                                                              ");
        System.out.println("                                      [1] Nạp tiền                                                              ");
        System.out.println("                                      [2] Chuyển tiền                                                        ");
        System.out.println("                                      [3] Rút tiền                                                               ");
        System.out.println("                                      [4] Lịch sử giao dịch                                               ");
        System.out.println("                                      [5] Thông tin tài khoản                                          ");
        System.out.println("                                      [6] Đăng xuất                                                           ");
        System.out.println("[Nhập vào lựa chọn:]                                                                                   ");
        System.out.println("======================================================");
    }
}
/*
 System.out.println("Đăng nhập với tư cách là: ");
                        int asSignInOption = Integer.parseInt(scan.nextLine());

                          "identify": 120594,
    "password": "Abc@1234",
    "money": 0,
    "name": "Ngô Hoàng Hùng ",
    "age": 23423,
    "address": "Long biên"
 */
// System.out.println("                                      [6] Phản hồi                                                             ");
