/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1211A051-PC
 */
import java.io.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class ReadPDFFile {
public static void main(String[] args) {
try {
PdfReader reader = new PdfReader("E:\\Users\\Ramakanth\\Desktop\\ap.pdf");
int n = reader.getNumberOfPages();
Rectangle psize = reader.getPageSize(1);
Document document = new Document(psize);
PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("new.txt"));
document.open();
PdfContentByte pdf = writer.getDirectContent();
document.newPage();
PdfImportedPage page = writer.getImportedPage(reader, 2);
pdf.addTemplate(page, .5f, 0, 0, .5f, 60, 120);
document.close();
} catch (Exception de) {}
}
}