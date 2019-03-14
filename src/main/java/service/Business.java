package service;

import com.google.common.collect.Lists;
import com.itextpdf.text.DocumentException;
import domain.Person;
import domain.dto.PersonDto;
import domain.dto.PersonsDto;
import lombok.AllArgsConstructor;
import util.PersonMapper;
import util.RandomUtils;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
public class Business {
    private PersonsSaver personsSaver;
    private PersonsApiService personsApiService;

    private void generatePersonsToList(int count, List<Person> personList) {
        for (int i = 0; i < count; ++i) {
            try {
                personList.add(PersonGenerator.generatePerson());
            } catch (IOException e1) {
                System.out.println("Не удалось сгенерировать человека с номером " + i);
            }
        }
    }

    public void work() {
        int count = RandomUtils.randomNumber(1, 30);
        List<Person> persons = Lists.newArrayList();

        try {
            PersonsDto personsDto = personsApiService.getPersons(count);
            for (PersonDto personDto : personsDto.getResults()) {
                Person person = PersonMapper.mapPersonDtoToPerson(personDto);
                PersonGenerator.fillValuesThatDtoHavent(person);
                persons.add(person);
            }
        } catch (IOException e) {
            System.out.println("Не удалось сгенерировать людей с помощью api");
            generatePersonsToList(count, persons);
        }

        try {
            personsSaver.save(persons);
        } catch (IOException | DocumentException e) {
            System.out.println("Ошибка во время сохранения людей в файл");
        }
    }
}
