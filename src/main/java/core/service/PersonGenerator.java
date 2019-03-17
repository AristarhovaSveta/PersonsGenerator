package core.service;

import core.domain.Person;
import core.domain.Sex;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import core.util.RandomUtils;

import java.io.IOException;

public class PersonGenerator {
    private static final String SURNAMES_FILE = "surnames.txt";
    private static final String NAMES_FILE = "names.txt";
    private static final String PATRONYMICS_FILE = "second_names.txt";
    private static final String COUNTRIES_FILE = "countries.txt";
    private static final String AREAS_FILE = "areas.txt";
    private static final String CITIES_FILE = "cities.txt";
    private static final String STREETS_FILE = "streets.txt";
    private static final int PEOPLE_LIVE_DURATION = 100;

    public static Person generatePerson() throws IOException {
        int number = RandomUtils.randomNumber(0, 1);
        Sex sex = number == 0 ? Sex.MALE : Sex.FEMALE;
        String filePrefix = "";
        switch (sex) {
            case MALE:
                filePrefix = "men_";
                break;
            case FEMALE:
                filePrefix = "women_";
                break;
        }
        String surname = RandomUtils.randomLineFromResourceFile(filePrefix + SURNAMES_FILE);
        String name = RandomUtils.randomLineFromResourceFile(filePrefix + NAMES_FILE);
        String patronymic = RandomUtils.randomLineFromResourceFile(filePrefix + PATRONYMICS_FILE);
        LocalDate birthdate = RandomUtils.randomDate(PEOPLE_LIVE_DURATION);
        int age = Years.yearsBetween(birthdate, LocalDate.now()).getYears();
        return new Person(
                surname, name, patronymic,
                age, sex, birthdate,
                RandomUtils.randomInn(),
                String.valueOf(RandomUtils.randomNumber(100000, 200000)),
                RandomUtils.randomLineFromResourceFile(COUNTRIES_FILE),
                RandomUtils.randomLineFromResourceFile(AREAS_FILE),
                RandomUtils.randomLineFromResourceFile(CITIES_FILE),
                RandomUtils.randomLineFromResourceFile(STREETS_FILE),
                RandomUtils.randomNumber(1, 100),
                RandomUtils.randomNumber(1, 100));
    }

    public static void fillValuesThatDtoHavent(Person person) throws IOException {
        String filePrefix = "";
        switch (person.getSex()) {
            case MALE:
                filePrefix = "men_";
                break;
            case FEMALE:
                filePrefix = "women_";
                break;
        }
        person.setPatronymic(RandomUtils.randomLineFromResourceFile(filePrefix + PATRONYMICS_FILE));
        person.setInn(RandomUtils.randomInn());
        person.setPostcode(String.valueOf(RandomUtils.randomNumber(100000, 200000)));
        person.setCountry(RandomUtils.randomLineFromResourceFile(COUNTRIES_FILE));
        person.setHome(RandomUtils.randomNumber(1, 100));
        person.setRoom(RandomUtils.randomNumber(1, 100));
    }
}