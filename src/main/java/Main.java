import com.google.common.collect.Lists;
import com.itextpdf.text.DocumentException;
import domain.Person;
import service.ExcelPersonsSaver;
import service.PdfPersonsSaver;
import service.PersonGenerator;
import util.RandomUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException, DocumentException {
        int count = RandomUtils.randomNumber(1, 30);
        List<Person> persons = Lists.newArrayList();
        for (int i = 0; i < count; ++i) {
            persons.add(PersonGenerator.generatePerson());
        }

        new ExcelPersonsSaver(new File("persons.xls"))
                .save(persons);

        new PdfPersonsSaver(new File("persons.pdf"))
                .save(persons);
    }
}
