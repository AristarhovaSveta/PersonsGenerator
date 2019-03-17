package core.util;

import core.domain.Person;
import core.domain.Sex;
import core.domain.Table;

import java.util.List;
import java.util.stream.Collectors;

public class PersonsToTableMapper {
    public static Table map(List<Person> persons) {
        String[] headers = {
                "Фамилия", "Имя", "Отчество",
                "Возраст", "Пол", "Дата рождения",
                "ИНН", "Индекс", "Страна", "Область",
                "Город", "Улица", "Дом", "Квартира"
        };
        String[][] rows = persons.stream().map(person -> new String[]{
                person.getSurname(), person.getName(), person.getPatronymic(),
                String.valueOf(person.getAge()), person.getSex() == Sex.MALE ? "М" : "Ж",
                DateUtils.formatDate(person.getBirthDate()),
                person.getInn(), person.getPostcode(), person.getCountry(),
                person.getArea(),
                person.getCity(), person.getStreet(), String.valueOf(person.getHome()),
                String.valueOf(person.getRoom())
        }).collect(Collectors.toList()).toArray(new String[0][0]);
        return new Table(headers, rows);
    }
}
