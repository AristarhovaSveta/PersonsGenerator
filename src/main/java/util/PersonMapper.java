package util;

import domain.Person;
import domain.dto.PersonDto;

public class PersonMapper {
    public static Person mapPersonDtoToPerson(PersonDto personDto) {
        return new Person(
                personDto.getName().getLast(),
                personDto.getName().getFirst(),
                personDto.getName().getTitle(),
                Integer.valueOf(personDto.getDob().getAge()),
                null,
                DateUtils.parse(personDto.getDob().getDate()).toLocalDate(),
                null,
                personDto.getLocation().getPostcode(),
                null,
                personDto.getLocation().getState(), personDto.getLocation().getCity(),
                personDto.getLocation().getStreet(),
                0,
                0
        );
    }
}
