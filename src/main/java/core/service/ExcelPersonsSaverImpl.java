package core.service;

import core.domain.Person;
import core.domain.Table;
import lombok.AllArgsConstructor;
import core.util.ExcelUtils;
import core.util.PersonsToTableMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor
public class ExcelPersonsSaverImpl implements PersonsSaver {
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
