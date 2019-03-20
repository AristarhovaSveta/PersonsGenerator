package core;

import core.service.Business;
import core.service.ExcelPersonsSaverImpl;
import core.service.PdfPersonsSaverImpl;
import core.service.PersonsApiService;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        PersonsApiService personsApiService = new PersonsApiService();

        ExcelPersonsSaverImpl excelPersonsSaverImpl = new ExcelPersonsSaverImpl(new File("persons.xls"));
        PdfPersonsSaverImpl pdfPersonsSaverImpl = new PdfPersonsSaverImpl(new File("persons.pdf"));

        Business business = new Business();
        business.setPersonsApiService(personsApiService);
        business.work();

        business.setPersonsSaver(excelPersonsSaverImpl);
        business.save();

        business.setPersonsSaver(pdfPersonsSaverImpl);
        business.save();
    }
}
