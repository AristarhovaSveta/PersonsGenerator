package domain;

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
}
