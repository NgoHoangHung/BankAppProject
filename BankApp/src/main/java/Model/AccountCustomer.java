package Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class AccountCustomer extends Person {
    private int identify;
    private String password;
    private int money;
    private History history;
    private String memoryHistory;
//    private ArrayList<String> processFeedback = new ArrayList<>();
//    private ArrayList<String> unProcessFeedback = new ArrayList<>();

    public AccountCustomer(String name, String password) {
        super(name);
        this.password = password;
    }

    public AccountCustomer(String name, int age, String address, int identify, String password, int money) {
        super(name, age, address);
        this.identify = identify;
        this.password = password;
        this.money = money;
    }
String specialWord(String str){
        String s1 ="";
    for (int i = 0; i<str.length();i++) {
            s1+="*";
    }
    return s1;
}
    @Override
    public String toString() {
        return "Identify= " + getIdentify() +
                "\nPassword= " + getPassword().substring(0, 3) + specialWord(getPassword().substring(3)) +
                "\nName= " + getName() +
                "\nAge= " + getAge() +
                "\nAddress= " + getAddress() + "\n";
    }
//    {"name":  "admin",
//            "password": "@TechMasterNDC!2022"},
}
