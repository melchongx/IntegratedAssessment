import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class TestComputer extends JFrame implements ActionListener {
    JPanel HomePage, SearchValid, SearchInvalid, CreateRecord, ViewRecord, EditRecord;
    JPanel HPPanel;
    JTextField Title, EnterPatientID;
    JLabel HomePrompt;
    JButton Search, Create;
    GridBagConstraints gbcHome = new GridBagConstraints();
    Color ustYellow = new Color(254,192,15);
    
    JPanel Homepage = new JPanel();
    //homepage.setBackground?
    
    JPanel SearchValid = new JPanel();
    JPanel SearchInvalid = new JPanel();
    JPanel CreateRecord = new JPanel();
    JPanel ViewRecord = new JPanel();
    JPanel EditRecord = new JPanel();
    
    public void toHomePage() {
        HomePage = new JPanel(); HomePage.setSize(1000,750); 
        HPPanel = new JPanel(); Title = new JTextField("UST MEDICAL RECORDS INTERFACE");
        Title.setFont(new Font("Arial", Font.BOLD, 20)); Title.setBackground(ustYellow); Title.setEditable(false);
        Border mainBorder = BorderFactory.createLineBorder(Color.BLACK, 7);
        HPPanel.setBorder(mainBorder);
        HPPanel.setLayout(new GridBagLayout());
        gbcHome.gridx = 0; gbcHome.gridy = 0; gbcHome.weightx = 0; gbcHome.gridwidth = 3; HPPanel.add(Title, gbcHome);
        HomePrompt = new JLabel("Enter Patient ID"); HomePrompt.setBackground(ustYellow);
        gbcHome.ipady = 20; gbcHome.gridx = 0; gbcHome.gridy = 1; gbcHome.weightx = 0.5; HPPanel.add(HomePrompt, gbcHome);
        EnterPatientID = new JTextField("",20);  EnterPatientID.setBackground(ustYellow);
        Search = new JButton("             Search             "); Search.setBackground(ustYellow);
        gbcHome.gridx = 0; gbcHome.gridy = 2;gbcHome.gridwidth = 1; HPPanel.add(EnterPatientID, gbcHome);
        gbcHome.gridx = 1; gbcHome.gridy = 2; HPPanel.add(Search, gbcHome);
        HomePrompt = new JLabel("or");
        gbcHome.gridx = 0; gbcHome.gridy = 3; gbcHome.weightx = 0.5; gbcHome.gridwidth = 3; HPPanel.add(this.HomePrompt, gbcHome);
        Create = new JButton("Create New Record"); Create.setBackground(ustYellow);
        gbcHome.gridx = 0; gbcHome.gridy = 4; gbcHome.weightx = 0.5; gbcHome.gridwidth = 3; HPPanel.add(Create, gbcHome);

        Create.addActionListener(this);
        HPPanel.setBounds(300, 200, 400, 300);
        HomePage.add(HPPanel);
        HomePage.setLayout(null);
        add(HomePage);
    }
    
    public void toSearchValid() {
    removeAll();
    //add(panel2); panel contains all components for search valid
    }
    
    public void toSearchInvalid() {
    removeAll();
    //add(panel3); panel contains all components for search invalid
    }
    
    public void toCreateRecord() {
    removeAll();
    //add(panel4); panel contains all components for create record
    }
    
    public void toViewRecord() {
    removeAll();
    //add(panel5); panel contains all components for view record
    }
    
    public void toEditRecord() {
    removeAll();
    //add(panel6); panel contains all components for edit record
    }

    public void toSearchValid() {

    }

    public void toCreateRecord() {
        remove(HomePage);
        CreateRecord = new JPanel(); CreateRecord.setSize(1000,750);
        CreateRecord.setBackground(ustYellow);
        add(CreateRecord);
        revalidate(); repaint();
    }
    
    public TestComputer() {
        setLayout(null);
        toHomePage();
        setSize(1000,750);
        setVisible(true);
        setResizable(false);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource() == Create) {
                toCreateRecord();
            } else {
                System.out.println("else");
            }
            
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
    }
    public static void main(String[] args) {
        TestComputer tc = new TestComputer();
        tc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
}
