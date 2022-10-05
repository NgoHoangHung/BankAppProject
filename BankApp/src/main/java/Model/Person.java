package Model;

import lombok.*;

@Setter@Getter@NoArgsConstructor@AllArgsConstructor
public class Person {
    private String name;
    private int age;
    private String address;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
