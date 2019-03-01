package service;

import com.itextpdf.text.DocumentException;
import domain.Person;
import domain.Table;
import lombok.AllArgsConstructor;
import util.PDFUtils;
import util.PersonsToTableMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor
public class PdfPersonsSaver implements PersonsSaver {
    private File file;

    @Override
    public void save(List<Person> persons) throws IOException, DocumentException {
        Table personsTable = PersonsToTableMapper.map(persons);
        PDFUtils.saveTable(file,
                personsTable.getHeaders(),
                personsTable.getRows());
        System.out.println("Файл создан. Путь " + file.getAbsolutePath());
    }
}
