import com.itextpdf.text.pdf.*;
public class ReadPDFMetaData{  
     public static void main(String[] args){
        try {
          PdfReader ReadInputPDF;
          ReadInputPDF = new PdfReader("E:\\Users\\Ramakanth\\Desktop\\ap.pdf");
          byte Document_MetaData[]=ReadInputPDF.getMetadata();
          /* dumping metadata on the screen */
          String strFileContent = new String(Document_MetaData); 
          System.out.println("File content : ");
          System.out.println(strFileContent);
          /* writing metadata into an xml file */
       //   FileOutputStream fos = new FileOutputStream("test.xml");
        //  fos.write(Document_MetaData);
       //   fos.close();
          }         
        catch (Exception i)
        {
            System.out.println(i);
        }
    }
}
