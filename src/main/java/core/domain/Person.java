package core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.joda.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Person {
    private String surname;
    private String name;
    private String patronymic;
    private int age;
    private Sex sex;
    private LocalDate birthDate;
    private String inn;
    private String postcode;
    private String country;
    private String area;
    private String city;
    private String street;
    private int home;
    private int room;

    public Person(String surname, String name, int age, Sex sex, LocalDate birthDate,
                  String area, String city, String street) {
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthDate = birthDate;
        this.area = area;
        this.city = city;
        this.street = street;
    }
}
