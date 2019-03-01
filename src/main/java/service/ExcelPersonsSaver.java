package service;

import domain.Person;
import domain.Table;
import lombok.AllArgsConstructor;
import util.ExcelUtils;
import util.PersonsToTableMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor
public class ExcelPersonsSaver implements PersonsSaver {
    private File file;

    @Override
    public void save(List<Person> persons) throws IOException {
        Table personsTable = PersonsToTableMapper.map(persons);
        ExcelUtils.save(file,
                personsTable.getHeaders(),
                personsTable.getRows());
        System.out.println("Файл создан. Путь " + file.getAbsolutePath());
    }
}
