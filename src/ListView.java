
import com.lowagie.text.pdf.PdfReader;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mnkey D.Luffy
 */
public class ListView extends JFrame {
  
   public void rr() throws Exception {
    DefaultTableModel model = new DefaultTableModel();
     model.addColumn("Title");
    model.addColumn("Author");
    
    JTable table = new JTable(model);
      
    int count=0;
    String author=null,title=null;
     File dir = new File("E:\\EBook\\");
    File[] files = dir.listFiles();
    for(File file : files)
    {
        System.out.println(file.toString());
    
    PdfReader reader = new PdfReader(file.toString());
    //System.out.print(reader.);
    Map info = reader.getInfo();
    for (Iterator i = info.keySet().iterator(); i.hasNext();) {
      String key = (String) i.next();
      String value = (String) info.get(key);
      System.out.println(key + ": " + value);
       if(key.equalsIgnoreCase("author"))
       {
           author=value;
       }
       else if(key.equalsIgnoreCase("title"))
       {
        
           title=value;
       }
    }
    System.out.append(title+"  "+author);
     model.insertRow(count, new Object[]{title,author});
    count++;
    model.insertRow(count, new Object[]{null,null});
    if (reader.getMetadata() == null) {
      System.out.println("No XML Metadata.");
    } else {
      System.out.println("XML Metadata: " + new String(reader.getMetadata()));
    }
 

    }

    table.getColumn("Title").setCellEditor(
        new ButtonEditor(new JCheckBox()));
    JScrollPane scroll = new JScrollPane(table);
    getContentPane().add(scroll);
    setSize(600, 500);
    setVisible(true);
  }
}

class ButtonRenderer extends JButton implements TableCellRenderer {

  public ButtonRenderer() {
    setOpaque(true);
  }

    @Override
  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
    } else {
      setForeground(table.getForeground());
      setBackground(UIManager.getColor("Button.background"));
    }
    setText((value == null) ? "" : value.toString());
    return this;
  }
}

/**
 * @version 1.0 11/09/98
 */

class ButtonEditor extends DefaultCellEditor {
  protected JButton button;
  public static int forRow=0;
  private String label;

  private boolean isPushed;

  public ButtonEditor(JCheckBox checkBox) {
    super(checkBox);
    button = new JButton();
    button.setOpaque(true);
    button.addActionListener(new ActionListener() {
            @Override
      public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
      }
    });
  }

    @Override
  public Component getTableCellEditorComponent(JTable table, Object value,
      boolean isSelected, int row, int column) {
    if (isSelected) {
      button.setForeground(table.getSelectionForeground());
      button.setBackground(table.getSelectionBackground());
    } else {
      button.setForeground(table.getForeground());
      button.setBackground(table.getBackground());
    }
   forRow=row;
    label = (value == null) ? "" : value.toString();
    button.setText(label);
    isPushed = true;
    return button;
  }

    @Override
  public Object getCellEditorValue() {
    if (isPushed) 
    {
      //JOptionPane.showMessageDialog(button, label + ": Ouch!");
        int count=0;
        String path=null;
        File dir = new File("E:\\EBook\\");
    File[] files = dir.listFiles();
     for(File file : files)
    {
        if(forRow==count)
        {
            System.out.println(file.toString());
            path=file.toString();
            break;
        }
        count++;
    }
     
        System.out.println(label);
 //   read obj=new read();
//     obj.main(path);
    }
    isPushed = false;
    return label;
  }
}