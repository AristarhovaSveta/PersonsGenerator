import service.Business;
import service.ExcelPersonsSaver;
import service.PdfPersonsSaver;
import service.PersonsApiService;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        PersonsApiService personsApiService = new PersonsApiService();

        ExcelPersonsSaver excelPersonsSaver = new ExcelPersonsSaver(new File("persons.xls"));
        PdfPersonsSaver pdfPersonsSaver = new PdfPersonsSaver(new File("persons.pdf"));

        new Business(excelPersonsSaver, personsApiService)
                .work();

        new Business(pdfPersonsSaver, personsApiService)
                .work();
    }
}
