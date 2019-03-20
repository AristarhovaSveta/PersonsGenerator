package core.service;

import core.dao.AddressDao;
import core.dao.PersonsDao;
import core.domain.entity.Address;
import core.domain.entity.Person;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class PersonsService {
    private PersonsDao personsDao;
    private AddressDao addressDao;

    public void savePerson(Person person) {
        Long id = addressDao.save(person.getAddress());
        person.getAddress().setId(id);
        personsDao.save(person);
    }

    public void saveOrUpdatePersons(List<Person> persons) {
        List<Address> addresses = persons.stream().map(Person::getAddress).collect(Collectors.toList());
        addressDao.save(addresses);
        for (Person person: persons) {
            if (!personsDao.isFioExists(person.getSurname(), person.getName(), person.getMiddlename())) {
                personsDao.save(person);
            } else {
                personsDao.update(person);
            }
        }
    }

    public List<Person> findAllPersons() {
        return personsDao.getAll();
    }
}
