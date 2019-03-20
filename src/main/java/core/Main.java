package core;

import core.dao.AddressDao;
import core.dao.PersonsDao;
import core.domain.entity.Address;
import core.domain.entity.Person;
import core.service.*;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        PersonsApiService personsApiService = new PersonsApiService();

        ExcelPersonsSaver excelPersonsSaver = new ExcelPersonsSaver(new File("persons.xls"));
        PdfPersonsSaver pdfPersonsSaver = new PdfPersonsSaver(new File("persons.pdf"));
        PersonsService personsService = new PersonsService(new PersonsDao(), new AddressDao());

        Business business = new Business();
        business.setPersonsService(personsService);

        business.setPersonsApiService(personsApiService);
        business.work();

        business.setPersonsSaver(excelPersonsSaver);
        business.save();

        business.setPersonsSaver(pdfPersonsSaver);
        business.save();
    }
}
