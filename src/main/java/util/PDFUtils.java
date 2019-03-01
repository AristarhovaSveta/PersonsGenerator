package util;

import com.google.common.io.Resources;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PDFUtils {
    private static final String FONT_LOCATION = Resources.getResource("times.ttf").toString();
    private static final int TABLE_MARGIN = 50;
    private static final int FONT_SIZE = 10;
    private static final String ENCODING = "cp1251";

    public static void saveTable(File file, String[] headers, String[][] rows) throws IOException, DocumentException {
        Document document = new Document(PageSize.A4, TABLE_MARGIN, TABLE_MARGIN, TABLE_MARGIN, TABLE_MARGIN);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
        BaseFont helvetica = BaseFont.createFont(
                FONT_LOCATION, ENCODING, BaseFont.EMBEDDED);
        Font font = new Font(helvetica, FONT_SIZE, Font.NORMAL);
        document.open();
        PdfPTable table = new PdfPTable(headers.length);
        for (String header: headers) {
            table.addCell(new PdfPCell(new Phrase(header, font)));
        }
        for (String[] row : rows) {
            for (String cell: row) {
                table.addCell(new PdfPCell(new Phrase(cell, font)));
            }
        }
        document.add(table);
        document.close();
    }
}
