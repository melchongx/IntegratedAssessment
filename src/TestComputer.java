import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestComputer extends JFrame implements ActionListener {
    
    JPanel Homepage = new JPanel();
    //homepage.setBackground?
    
    JPanel SearchValid = new JPanel();
    JPanel SearchInvalid = new JPanel();
    JPanel CreateRecord = new JPanel();
    JPanel ViewRecord = new JPanel();
    JPanel EditRecord = new JPanel();
    
    public void toHomePage() {
    removeAll();
    //add(panel1); panel contains all components for home page
    }
    
    public void toSearchValid() {
    removeAll();
    //add(panel1); panel contains all components for search valid
    }
    
    public void toSearchInvalid() {
    removeAll();
    //add(panel1); panel contains all components for search invalid
    }
    
    public void toCreateRecord() {
    removeAll();
    //add(panel1); panel contains all components for create record
    }
    
    public void toViewRecord() {
    removeAll();
    //add(panel1); panel contains all components for view record
    }
    
    public void toEditRecord() {
    removeAll();
    //add(panel1); panel contains all components for edit record
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            
        } catch (Exception ex) {
            //TODO: handle exception
        }
    }
    public static void main(String[] args) {
    }

    
}
