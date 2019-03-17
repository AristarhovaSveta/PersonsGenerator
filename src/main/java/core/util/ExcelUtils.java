package core.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {
    private static final String SHEET_NAME = "Persons";

    public static void save(File file, String[] headers, String[][] rows) throws IOException {
        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet(SHEET_NAME);
        int i = 0;

        Row headersRow = sheet.createRow(i++);
        for (int j = 0; j < headers.length; ++j) {
            String header = headers[j];
            createCell(headersRow, j, header);
        }

        for (String[] rowValues : rows) {
            Row row = sheet.createRow(i++);
            for (int j = 0; j < rowValues.length; ++j) {
                createCell(row, j, rowValues[j]);
            }
        }
        book.write(new FileOutputStream(file));
        book.close();
    }

    private static void createCell(Row row, int index, String value) {
        Cell cell = row.createCell(index);
        cell.setCellValue(value);
    }
}
