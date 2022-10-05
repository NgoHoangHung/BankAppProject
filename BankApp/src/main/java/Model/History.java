package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@NoArgsConstructor
@Getter
@Setter
public class History {
    private String note;
    private String headercontent;
    private Date creatAt;
    private int money;


    public History( Date creatAt,String headercontent,String note , int money) {
        this.note = note;
        this.headercontent = headercontent;
        this.creatAt = creatAt;
        this.money = money;
    }

//    public History(Date creatAt,String headercontent,  int money) {
//        this.headercontent = headercontent;
//        this.creatAt = creatAt;
//        this.money = money;
//    }

    //hỏi thâầy chỗ này muốn để kiểu abstract xong cho ghi đè để tránh public quá nhiều?
public String historyNote(Date creatAtTmp,String headercontent,String note,  int money) {
    return "\n"+String.valueOf(creatAtTmp)+"\n"+headercontent+ "\nNội dung: "+
            note +"\nMoney: " +String.valueOf(money)+ ".";
}

    @Override
    public String toString() {
        return
                "Ngày tháng:" + getCreatAt() +
                "\n" +getHeadercontent()+
                "\nNội dung: " + getNote() +
                "\nMoney: " + getMoney() ;
    }
}
