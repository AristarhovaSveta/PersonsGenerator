package core;

import core.service.Business;
import core.service.ExcelPersonsSaver;
import core.service.PdfPersonsSaver;
import core.service.PersonsApiService;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        PersonsApiService personsApiService = new PersonsApiService();

        ExcelPersonsSaver excelPersonsSaver = new ExcelPersonsSaver(new File("persons.xls"));
        PdfPersonsSaver pdfPersonsSaver = new PdfPersonsSaver(new File("persons.pdf"));

        Business business = new Business();
        business.setPersonsApiService(personsApiService);
        business.work();

        business.setPersonsSaver(excelPersonsSaver);
        business.save();

        business.setPersonsSaver(pdfPersonsSaver);
        business.save();
    }
}
