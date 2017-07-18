/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1211A051-PC
 */

import com.itextpdf.text.pdf.*;
import java.util.Iterator;
import java.util.HashMap;
public class meta{  
     public static void main(String[] args){
        try {
          PdfReader ReadInputPDF;
          ReadInputPDF = new PdfReader("E:\\Users\\Ramakanth\\Desktop\\The Accidental Billionaires.pdf");
          HashMap hMap = new HashMap();
          hMap=ReadInputPDF.getInfo();
          Iterator iterator = hMap.keySet().iterator();
          while (iterator.hasNext()) {
                  String key = (String) iterator.next();
                  if(key.equals("Title")|| key.equals("Author"))
                  System.out.println(key + ":" + hMap.get(key));
          }
          }
         
        catch (Exception i)
        {
            System.out.println(i);
        }
    }
}
