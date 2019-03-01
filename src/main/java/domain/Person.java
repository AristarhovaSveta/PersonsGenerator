package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.joda.time.LocalDate;

@AllArgsConstructor
@Getter
@ToString
public class Person {
    private final String surname;
    private final String name;
    private final String patronymic;
    private final int age;
    private final Sex sex;
    private final LocalDate birthDate;
    private final String inn;
    private final int postcode;
    private final String country;
    private final String area;
    private final String city;
    private final String street;
    private final int home;
    private final int room;
}
