package core.util;

import core.domain.Person;
import core.domain.Sex;
import core.domain.dto.PersonDto;

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
}
