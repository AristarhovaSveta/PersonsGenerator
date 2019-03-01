package service;

import com.itextpdf.text.DocumentException;
import domain.Person;

import java.io.IOException;
import java.util.List;

public interface PersonsSaver {
    void save(List<Person> persons) throws IOException, DocumentException;
}
