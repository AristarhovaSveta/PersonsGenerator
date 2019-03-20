package core;

import core.dao.AddressDao;
import core.dao.PersonsDao;
import core.service.*;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        PersonsApiService personsApiService = new PersonsApiService();

        ExcelPersonsSaverImpl excelPersonsSaverImpl = new ExcelPersonsSaverImpl(new File("persons.xls"));
        PdfPersonsSaverImpl pdfPersonsSaverImpl = new PdfPersonsSaverImpl(new File("persons.pdf"));

        Business business = new Business();
        business.setPersonsService(new PersonsService(new PersonsDao(), new AddressDao()));
        business.setPersonsApiService(personsApiService);
        business.work();

        business.setPersonsSaver(excelPersonsSaverImpl);
        business.save();

        business.setPersonsSaver(pdfPersonsSaverImpl);
        business.save();
    }
}
