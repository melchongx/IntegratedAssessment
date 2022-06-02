import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;

public class TestComputer extends JFrame implements ActionListener {
    JPanel HomePage, SearchValid, SearchInvalid, CreateRecord, ViewRecord, EditRecord;
    JPanel HPPanel, VSearch, ISearch, CPanelP, CPanelEC, CPanelDR;
    JTextField Title, EnterPatientID;
    JLabel HomePrompt1, HomePrompt2, ValSearchPrompt, InvalSearchPrompt1,InvalSearchPrompt2;
    JButton Search, Create, View, Edit, InvalReturn;
    GridBagConstraints gbcHome = new GridBagConstraints();
    Color ustYellow = new Color(254,192,15);

    static String uHome = System.getProperty("user.home");
    static String fSeparator = System.getProperty("file.separator");
    static String path = uHome + fSeparator + "ustMedRec.csv";
    public static void myFile() {
        File myFile = new File(path);
        System.out.print(path);
    }

    public void toHomePage() {
        
    }   
    
    public void toSearchValid() {
        remove(HomePage);
        SearchValid = new JPanel(); SearchValid.setSize(1000,750); add(SearchValid);
        HPPanel.remove(HomePrompt2); HPPanel.remove(Create); HPPanel.remove(EnterPatientID); HPPanel.remove(Search); HPPanel.remove(HomePrompt1);
        ValSearchPrompt = new JLabel("Patient ID Valid");
        gbcHome.ipady = 20; gbcHome.gridx = 0; gbcHome.gridy = 1; HPPanel.add(ValSearchPrompt, gbcHome);
        View = new JButton("          View          "); View.setBackground(ustYellow);
        Edit = new JButton("          Edit          "); Edit.setBackground(ustYellow);
        gbcHome.gridx = 0; gbcHome.gridy = 2; gbcHome.gridwidth = 1; HPPanel.add(View, gbcHome);
        gbcHome.gridx = 1; gbcHome.gridy = 2; HPPanel.add(Edit, gbcHome);
        

        View.addActionListener(this); Edit.addActionListener(this);
        SearchValid.add(HPPanel);
        SearchValid.setLayout(null);
        
        revalidate(); repaint();
    }
    
    public void toSearchInvalid() {
    remove(HomePage);
    SearchInvalid = new JPanel(); SearchInvalid.setSize(1000,750);
    HPPanel.remove(HomePrompt2); HPPanel.remove(Create); HPPanel.remove(EnterPatientID); HPPanel.remove(Search); HPPanel.remove(HomePrompt1);
    InvalSearchPrompt1 = new JLabel("Invalid Patient ID");
    gbcHome.gridx = 0; gbcHome.gridy = 1; HPPanel.add(InvalSearchPrompt1, gbcHome);
    InvalSearchPrompt2 = new JLabel("Please input a valid patient ID");
    gbcHome.gridx = 0; gbcHome.gridy = 2; HPPanel.add(InvalSearchPrompt2, gbcHome);
    InvalReturn = new JButton("Return"); InvalReturn.setBackground(ustYellow);
    gbcHome.gridx = 0; gbcHome.gridy = 3; HPPanel.add(InvalReturn, gbcHome);

    InvalReturn.addActionListener(this);
    SearchInvalid.add(HPPanel);
    SearchInvalid.setLayout(null);
    add(SearchInvalid);
    revalidate(); repaint();
    }
    
    public void toCreateRecord() {
        remove(HomePage);
        CreateRecord = new JPanel(); CreateRecord.setSize(1000,750);
        add(CreateRecord);
        revalidate(); repaint();
    }
    
    public void toViewRecord() {
    removeAll();
    //add(panel5); panel contains all components for view record
    }
    
    public void toEditRecord() {
    removeAll();
    //add(panel6); panel contains all components for edit record
    }

    
    public TestComputer() {
        setLayout(null);
        HomePage = new JPanel(); HomePage.setSize(1000,750); 
        HPPanel = new JPanel(); Title = new JTextField("UST MEDICAL RECORDS INTERFACE");
        Title.setFont(new Font("Arial", Font.BOLD, 20)); Title.setBackground(ustYellow); Title.setEditable(false);
        Border mainBorder = BorderFactory.createLineBorder(Color.BLACK, 10);
        HPPanel.setBorder(mainBorder);
        HPPanel.setLayout(new GridBagLayout());
        gbcHome.gridx = 0; gbcHome.gridy = 0; gbcHome.weightx = 0; gbcHome.gridwidth = 3; HPPanel.add(Title, gbcHome);
        HomePrompt1 = new JLabel("Enter Patient ID"); HomePrompt1.setBackground(ustYellow);
        gbcHome.ipady = 20; gbcHome.gridx = 0; gbcHome.gridy = 1; gbcHome.weightx = 0.5; HPPanel.add(HomePrompt1, gbcHome);
        EnterPatientID = new JTextField("",20);  EnterPatientID.setBackground(ustYellow);
        Search = new JButton("             Search             "); Search.setBackground(ustYellow);
        gbcHome.gridx = 0; gbcHome.gridy = 2;gbcHome.gridwidth = 1; HPPanel.add(EnterPatientID, gbcHome);
        gbcHome.gridx = 1; gbcHome.gridy = 2; HPPanel.add(Search, gbcHome);
        HomePrompt2 = new JLabel("or");
        gbcHome.gridx = 0; gbcHome.gridy = 3; gbcHome.weightx = 0.5; gbcHome.gridwidth = 3; HPPanel.add(this.HomePrompt2, gbcHome);
        Create = new JButton("Create New Record"); Create.setBackground(ustYellow);
        gbcHome.gridx = 0; gbcHome.gridy = 4; gbcHome.weightx = 0.5; gbcHome.gridwidth = 3; HPPanel.add(Create, gbcHome);
  
        Create.addActionListener(this); Search.addActionListener(this);
        HPPanel.setBounds(300, 200, 400, 300);
        HomePage.add(HPPanel);
        HomePage.setLayout(null);
        add(HomePage);
        setSize(1000,750);
        setVisible(true);
        setResizable(false);
    }

    public void PatientValidityCheck() {
        System.out.println("in ");
        try {
            System.out.println("in try");
            Integer input = Integer.parseInt(EnterPatientID.getText());
            BufferedReader br = new BufferedReader(new FileReader(path));
            String info = br.readLine();
            String[] lineHolder = info.split(",");
            Integer holder = Integer.parseInt(lineHolder[0]);
            while(info != null) {
                System.out.println("in while");
                if (input.equals(holder)) {
                    toSearchValid();
                    System.out.println("success");
                    return;
                } else {
                    info = br.readLine();
                    lineHolder = info.split(",");
                    holder = Integer.parseInt(lineHolder[0]);
                    System.out.println("loop");
                }
            } 
        
        } catch (Exception PVCe) {
            PVCe.getMessage();
        }
        System.out.println("Invalid");
        toSearchInvalid();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource() == Create) {
                toCreateRecord();
            } else if(e.getSource() == Search) {
                System.out.println("Searching");
                PatientValidityCheck();
            } else if(e.getSource() == Edit) {

            } else if(e.getSource() == View) {

            } else if(e.getSource() == InvalReturn) {
                toHomePage();
            }
            
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
    }
    public static void main(String[] args) {
        myFile();
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(path,true));
            pw.println(12345);
            pw.close();
        } catch (IOException eww) {
            eww.getMessage();
        }
        TestComputer tc = new TestComputer();
        tc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
}
