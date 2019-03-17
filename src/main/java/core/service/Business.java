package core.service;

import com.google.common.collect.Lists;
import com.itextpdf.text.DocumentException;
import core.domain.Person;
import core.domain.dto.PersonDto;
import core.domain.dto.PersonsDto;
import lombok.AllArgsConstructor;
import core.util.PersonMapper;
import core.util.RandomUtils;
import lombok.Setter;

import java.io.IOException;
import java.util.List;

public class Business {
    private List<Person> persons = Lists.newArrayList();

    @Setter
    private PersonsSaver personsSaver;

    @Setter
    private PersonsApiService personsApiService;

    private void generatePersons(int count) {
        for (int i = 0; i < count; ++i) {
            try {
                persons.add(PersonGenerator.generatePerson());
            } catch (IOException e1) {
                System.out.println("Не удалось сгенерировать человека с номером " + i);
            }
        }
    }

    public void work() {
        int count = RandomUtils.randomNumber(1, 30);

        try {
            PersonsDto personsDto = personsApiService.getPersons(count);
            System.out.println("Соединение установлено");
            for (PersonDto personDto : personsDto.getResults()) {
                Person person = PersonMapper.mapPersonDtoToPerson(personDto);
                PersonGenerator.fillValuesThatDtoHavent(person);
                persons.add(person);
            }
        } catch (IOException e) {
            System.out.println("Нет соединения");
            System.out.println("Не удалось сгенерировать людей с помощью api");
            generatePersons(count);
        }
    }

    public void save() {
        try {
            personsSaver.save(persons);
        } catch (IOException | DocumentException e) {
            System.out.println("Ошибка во время сохранения людей в файл");
        }
    }
}
