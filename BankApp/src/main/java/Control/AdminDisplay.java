package Control;

import Model.AccountCustomer;

import static Control.CustomerManager.accSequenceManager;

public class AdminDisplay {
    public static void showAllCustermor() {
        System.out.println("============================================");
//    System.out.println(accSequenceManager.size());

        for (AccountCustomer obj : accSequenceManager) {
            System.out.println( "Identify= " + obj.getIdentify() +
                    "\nPassword= " + obj.getPassword()+
                    "\nName= " + obj.getName() +
                    "\nAge= " + obj.getAge() +
                    "\nAddress= " + obj.getAddress() + "\n");
        }
    }

}

