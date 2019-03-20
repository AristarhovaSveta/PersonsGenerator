package core.util;

import core.domain.Person;
import core.domain.Sex;
import core.domain.dto.PersonDto;
import core.domain.entity.Address;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.Years;

import java.util.Date;

public class PersonMapper {
    public static Person mapPersonDtoToPerson(PersonDto personDto) {
        return new Person(
                personDto.getName().getLast(),
                personDto.getName().getFirst(),
                Integer.valueOf(personDto.getDob().getAge()),
                personDto.getGender().equals("male") ? Sex.MALE : Sex.FEMALE,
                DateUtils.parse(personDto.getDob().getDate()).toLocalDate(),
                personDto.getLocation().getState(),
                personDto.getLocation().getCity(),
                personDto.getLocation().getStreet()
        );
    }

    public static core.domain.entity.Person mapPersonToEntity(Person person) {
        core.domain.entity.Person personEntity = new core.domain.entity.Person();
        personEntity.setName(person.getName());
        personEntity.setSurname(person.getSurname());
        personEntity.setBirthday(person.getBirthDate().toDate());
        personEntity.setGender(person.getSex() == Sex.MALE ? "M" : "F");
        personEntity.setMiddlename(person.getPatronymic());
        personEntity.setInn(person.getInn());
        Address address = new Address();
        address.setCity(person.getCity());
        address.setCountry(person.getCountry());
        address.setFlat(person.getRoom());
        address.setHouse(person.getHome());
        address.setPostcode(person.getPostcode());
        address.setRegion(person.getArea());
        address.setStreet(person.getStreet());
        personEntity.setAddress(address);
        return personEntity;
    }

    public static Person mapEntityToPerson(core.domain.entity.Person person) {
        return new Person(
                person.getSurname(),
                person.getName(),
                person.getMiddlename(),
                Years.yearsBetween(new LocalDate(person.getBirthday()), LocalDate.now()).getYears(),
                person.getGender().equals("MALE") ? Sex.MALE : Sex.FEMALE,
                new LocalDate(person.getBirthday()),
                person.getInn(),
                person.getAddress().getPostcode(),
                person.getAddress().getCountry(),
                person.getAddress().getRegion(),
                person.getAddress().getCity(),
                person.getAddress().getStreet(),
                person.getAddress().getHouse(),
                person.getAddress().getFlat()
        );
    }
}
