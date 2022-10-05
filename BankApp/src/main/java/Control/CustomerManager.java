package Control;

import Model.AccountCustomer;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Control.SignIn.identifyInput;

//ko nên để lớp này là public mà chuyển thành default
public class CustomerManager {

    //    Quản lí hệ thống ngân hàng qua một đối tượng AccountCustomer
    static Scanner scan = new Scanner(System.in);
    static List<AccountCustomer> accSequenceManager = new ArrayList<>();
    private static int indexCurrentAccount;

     static int getIndexCurrentAccount() {
        return indexCurrentAccount;
    }

     public static void setIndexCurrentAccount(int indexCurrentAccount) {
        CustomerManager.indexCurrentAccount = indexCurrentAccount;
    }


public static void infoCustomer(){
         AccountCustomer accobj = accSequenceManager.get(getIndexCurrentAccount());
    System.out.println(accobj.getName());
}
    public CustomerManager() {
//        accSequenceManager.add(new AccountCustomer("Nguyễn Thành Trung", 23, "Tan Mai",
//                342423, "Abc@1234", 5000000));
//        accSequenceManager.add(new AccountCustomer("Ngô Hoàng Hùng", 29, "Long Biên",
//                343425, "Abc@1234", 2000000));
//        accSequenceManager.add(new AccountCustomer("Phạm Quốc Thái", 24, "Tố Hữu",
//                543425, "Abc@1234", 3000000));
    }

    /*
    checkid được sử dụng nhiều nên cần khai báo từ này trước.
     sử dụng trong hàm đăng nhập và hàm tạo tài khoản mới (đăng kí)
     sử dụng để lấy vị trí người dùng hiện tại
     */
    static boolean checkId(int id) {
        for (AccountCustomer obj : accSequenceManager) {
            if (obj.getIdentify() == id) {
                setIndexCurrentAccount(accSequenceManager.indexOf(obj));
                return true;
            }
        }
        return false;
    }

    //hàm kiểm tra tài khoản đích trong ngân hàng để chuyển tiền
    public static boolean checkIdDestination(int id) {
        for (AccountCustomer obj : accSequenceManager) {
            if (obj.getIdentify() == id) {
                return true;
            }
        }
        return false;
    }

    //kiểm tra pass
    static boolean checkPassword(String strInput) {
        for (AccountCustomer obj : accSequenceManager) {
            if (obj.getPassword().equals(strInput))
                return true;
        }
        return false;
    }
    public static void importDatabase() {
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader("database.json");
            Type type = new TypeToken<ArrayList<AccountCustomer>>() {}.getType();
            accSequenceManager = gson.fromJson(reader, type);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    static void exportDatabase() {
        Gson gson = new Gson();
        String dataBaseJson = gson.toJson(accSequenceManager);

        File dataBaseFile = new File("database.json");

        try {
            FileWriter writer = new FileWriter(dataBaseFile);
            writer.write(dataBaseJson);
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
