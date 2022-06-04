import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
import java.util.UUID;

public class TestComputer extends JFrame implements ActionListener {
    JPanel HomePage, SearchValid, SearchInvalid, CreateRecord, ViewRecord;
    JPanel HPPanel, VSearch, ISearch, CPanelP, CPanelEC, CPanelDR, VPanelP, VPanelEC, VPanelDR;
    JTextField EnterPatientID;
    JLabel HomePrompt1, HomePrompt2, ValSearchPrompt, InvalSearchPrompt1,InvalSearchPrompt2;
    JLabel lblCPLn, lblCPGn, lblCPMn, lblCPS, lblCPBd, lblCPA, lblCECLn, lblCECGn, lblCECMn, lblCECRel, lblCECCn, lblCECA, lblCDRDate, lblCDRDiag, lblCDRTreat;
    JLabel lblVPLn, lblVPGn, lblVPMn, lblVPS, lblVPBd, lblVPA, lblVECLn, lblVECGn, lblVECMn, lblVECRel, lblVECCn, lblVECA, lblVDRDate, lblVDRDiag, lblVDRTreat;
    JTextField CPLn, CPGn, CPMn, CPS, CPBd, CPA, CECLn, CECGn, CECMn, CECRel, CECCn, CECA, CDRDate;
    JTextField VPLn, VPGn, VPMn, VPS, VPBd, VPA, VECLn, VECGn, VECMn, VECRel, VECCn, VECA, VDRDate;
    JTextArea CDRDiag, CDRTreat, VDRDiag, VDRTreat;
    JButton Search, Create, View, Edit, InvalReturn, CreateSubmit, CreateReturn;
    GridBagConstraints gbc = new GridBagConstraints();
    Color ustYellow = new Color(254,192,15);
    Border mainBorder = BorderFactory.createLineBorder(Color.BLACK, 10);
    JTextField HTitle = new JTextField("UST MEDICAL RECORDS INTERFACE");
    JTextField SVTitle = new JTextField("UST MEDICAL RECORDS INTERFACE");
    JTextField SITitle = new JTextField("UST MEDICAL RECORDS INTERFACE");
    JTextField PatientInfo = new JTextField("PATIENT INFORMATION");
    JTextField VPatientInfo = new JTextField("PATIENT INFORMATION");
    JTextField EmerCon = new JTextField("EMERGENCY CONTACT");
    JTextField VEmerCon = new JTextField("EMERGENCY CONTACT");
    JTextField DiagRep = new JTextField("DIAGNOSIS REPORT");
    JTextField VDiagRep = new JTextField("DIAGNOSIS REPORT");
        
    static String uHome = System.getProperty("user.home");
    static String fSeparator = System.getProperty("file.separator");
    static String path = uHome + fSeparator + "ustMedRec.csv";

    public static void myFile() {
        File myFile = new File(path);
        System.out.print(path);
    }
    
    public TestComputer() { //////// TEST COMPUTER ???????????????????????????? ASSAFSDFFDGFGDNHRHTYJYUMTNYNYNYMY
        setLayout(null);
        HomePage = new JPanel(); HomePage.setSize(1000,750); 
        HPPanel = new JPanel(); HPPanel.setBorder(mainBorder); HPPanel.setLayout(new GridBagLayout());
        HTitle.setFont(new Font("Arial", Font.BOLD, 20)); HTitle.setBackground(ustYellow); HTitle.setEditable(false);
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0; gbc.gridwidth = 3; HPPanel.add(HTitle, gbc);
        HomePrompt1 = new JLabel("Enter Patient ID"); HomePrompt1.setBackground(ustYellow);
        gbc.ipady = 20; gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.5; HPPanel.add(HomePrompt1, gbc);
        EnterPatientID = new JTextField("",20);  EnterPatientID.setBackground(ustYellow);
        Search = new JButton("             Search             "); Search.setBackground(ustYellow);
        gbc.gridx = 0; gbc.gridy = 2;gbc.gridwidth = 1; HPPanel.add(EnterPatientID, gbc);
        gbc.gridx = 1; gbc.gridy = 2; HPPanel.add(Search, gbc);
        HomePrompt2 = new JLabel("or");
        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0.5; gbc.gridwidth = 3; HPPanel.add(this.HomePrompt2, gbc);
        Create = new JButton("Create New Record"); Create.setBackground(ustYellow);
        gbc.gridx = 0; gbc.gridy = 4; gbc.weightx = 0.5; gbc.gridwidth = 3; HPPanel.add(Create, gbc);
  
        Create.addActionListener(this); Search.addActionListener(this);
        HPPanel.setBounds(300, 200, 400, 300);
        HomePage.add(HPPanel);
        HomePage.setLayout(null);
        add(HomePage);
        setSize(1000,750);
        setVisible(true);
        setResizable(false);
        revalidate(); repaint();

        // SEARCH VALID
        SearchValid = new JPanel(); SearchValid.setSize(1000,750); 
        VSearch = new JPanel(); VSearch.setBorder(mainBorder); VSearch.setLayout(new GridBagLayout());
        SVTitle.setFont(new Font("Arial", Font.BOLD, 20)); SVTitle.setBackground(ustYellow); SVTitle.setEditable(false);
        gbc.gridx = 0; gbc.gridy = 0;  gbc.gridwidth = 3; VSearch.add(SVTitle,gbc);
        ValSearchPrompt = new JLabel("Patient ID Valid");
        gbc.ipady = 20; gbc.gridx = 0; gbc.gridy = 1; VSearch.add(ValSearchPrompt, gbc);
        View = new JButton("          View          "); View.setBackground(ustYellow);
        Edit = new JButton("          Edit          "); Edit.setBackground(ustYellow);
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 1; VSearch.add(View, gbc);
        gbc.gridx = 1; gbc.gridy = 2; VSearch.add(Edit, gbc);

        View.addActionListener(this); Edit.addActionListener(this);
        VSearch.setBounds(300, 200, 400, 300);
        SearchValid.add(VSearch);
        SearchValid.setLayout(null);

        // SEARCH INVALID
        SearchInvalid = new JPanel(); SearchInvalid.setSize(1000,750);
        ISearch = new JPanel(); ISearch.setBorder(mainBorder); ISearch.setLayout(new GridBagLayout());
        SITitle.setFont(new Font("Arial", Font.BOLD, 20)); SITitle.setBackground(ustYellow); SITitle.setEditable(false);
        gbc.gridx = 0; gbc.gridy = 0; ISearch.add(SITitle, gbc);
        InvalSearchPrompt1 = new JLabel("Invalid Patient ID");
        gbc.gridx = 0; gbc.gridy = 1; ISearch.add(InvalSearchPrompt1, gbc);
        InvalSearchPrompt2 = new JLabel("Please input a valid patient ID");
        gbc.gridx = 0; gbc.gridy = 2; ISearch.add(InvalSearchPrompt2, gbc);
        InvalReturn = new JButton("Return"); InvalReturn.setBackground(ustYellow);
        gbc.gridx = 0; gbc.gridy = 3; ISearch.add(InvalReturn, gbc);

        InvalReturn.addActionListener(this);
        ISearch.setBounds(300, 200, 400, 300);
        SearchInvalid.add(ISearch);
        SearchInvalid.setLayout(null);

        // CREATE RECORD
        CreateRecord = new JPanel(); CreateRecord.setSize(1000,750); 
        CPanelP = new JPanel(); CPanelP.setBackground(ustYellow);
        PatientInfo.setFont(new Font("Arial", Font.BOLD, 20)); 
        PatientInfo.setBackground(Color.GRAY); PatientInfo.setEditable(false);
        CPanelP.setLayout(new GridBagLayout());
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 3; gbc.ipady = 15; CPanelP.add(PatientInfo, gbc);
        lblCPLn = new JLabel("Last Name"); gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1; CPanelP.add(lblCPLn, gbc);
        CPLn = new JTextField("", 20); gbc.gridx = 1; gbc.gridy = 1; CPanelP.add(CPLn, gbc);
        lblCPGn = new JLabel("Given Name"); gbc.gridx = 0; gbc.gridy = 2; CPanelP.add(lblCPGn, gbc);
        CPGn = new JTextField("", 20); gbc.gridx = 1; gbc.gridy = 2; CPanelP.add(CPGn, gbc);
        lblCPMn = new JLabel("Middle Name"); gbc.gridx = 0; gbc.gridy = 3; CPanelP.add(lblCPMn, gbc);
        CPMn = new JTextField("", 20); gbc.gridx = 1; gbc.gridy = 3; CPanelP.add(CPMn, gbc);
        lblCPS = new JLabel("Sex (M/F"); gbc.gridx = 0; gbc.gridy = 4; CPanelP.add(lblCPS, gbc);
        CPS = new JTextField("", 20); gbc.gridx = 1; gbc.gridy = 4; CPanelP.add(CPS, gbc);
        lblCPBd = new JLabel("Date of Birth (mm/dd/yyyy)"); gbc.gridx = 0; gbc.gridy = 5; CPanelP.add(lblCPBd, gbc);
        CPBd = new JTextField("", 20); gbc.gridx = 1; gbc.gridy = 5; CPanelP.add(CPBd, gbc);
        lblCPA = new JLabel("Address"); gbc.gridx = 0; gbc.gridy = 6; CPanelP.add(lblCPA, gbc);
        CPA = new JTextField("", 20); gbc.gridx = 1; gbc.gridy = 6; CPanelP.add(CPA, gbc);

        CPanelEC = new JPanel(); CPanelEC.setBackground(ustYellow);
        EmerCon.setFont(new Font("Arial", Font.BOLD, 20)); 
        EmerCon.setBackground(Color.GRAY); EmerCon.setEditable(false);
        CPanelEC.setLayout(new GridBagLayout());
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 3; gbc.ipady = 15; CPanelEC.add(EmerCon, gbc);
        lblCECLn = new JLabel("Last Name"); gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1; CPanelEC.add(lblCECLn, gbc);
        CECLn = new JTextField("", 20); gbc.gridx = 1; gbc.gridy = 1; CPanelEC.add(CECLn, gbc);
        lblCECGn = new JLabel("Given Name"); gbc.gridx = 0; gbc.gridy = 2; CPanelEC.add(lblCECGn, gbc);
        CECGn = new JTextField("", 20); gbc.gridx = 1; gbc.gridy = 2; CPanelEC.add(CECGn, gbc);
        lblCECMn = new JLabel("Middle Name"); gbc.gridx = 0; gbc.gridy = 3; CPanelEC.add(lblCECMn, gbc);
        CECMn = new JTextField("", 20); gbc.gridx = 1; gbc.gridy = 3; CPanelEC.add(CECMn, gbc);
        lblCECRel = new JLabel("Relationship to Patient"); gbc.gridx = 0; gbc.gridy = 4; CPanelEC.add(lblCECRel, gbc);
        CECRel = new JTextField("", 20); gbc.gridx = 1; gbc.gridy = 4; CPanelEC.add(CECRel, gbc);
        lblCECCn = new JLabel("Contact Number"); gbc.gridx = 0; gbc.gridy = 5; CPanelEC.add(lblCECCn, gbc);
        CECCn = new JTextField("", 20); gbc.gridx = 1; gbc.gridy = 5; CPanelEC.add(CECCn, gbc);
        lblCECA = new JLabel("Address"); gbc.gridx = 0; gbc.gridy = 6; CPanelEC.add(lblCECA, gbc);
        CECA = new JTextField("", 20); gbc.gridx = 1; gbc.gridy = 6; CPanelEC.add(CECA, gbc);


        JScrollPane scrollDiag = new JScrollPane(CDRDiag);
        JScrollPane scrollTreat = new JScrollPane(CDRTreat);
        CPanelDR = new JPanel(); CPanelDR.setBackground(ustYellow);
        DiagRep.setFont(new Font("Arial", Font.BOLD, 20));
        DiagRep.setBackground(Color.GRAY); DiagRep.setEditable(false);
        CPanelDR.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 5; gbc.ipady = 15; CPanelDR.add(DiagRep, gbc);
        lblCDRDate = new JLabel("Date (mm/dd/yyyy)"); gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1; CPanelDR.add(lblCDRDate, gbc);
        CDRDate = new JTextField("", 75); gbc.gridx = 1; gbc.gridy = 1; CPanelDR.add(CDRDate, gbc);
        lblCDRDiag = new JLabel("Diagnosis"); gbc.gridx = 0; gbc.gridy = 2; gbc.ipady = 70; gbc.gridwidth = 3; gbc.weightx=0.25; CPanelDR.add(lblCDRDiag, gbc);
        CDRDiag = new JTextArea("", 150,2); gbc.gridx = 1; gbc.gridy = 2;gbc.weightx=2.75; CPanelDR.add(scrollDiag, gbc);
        lblCDRTreat = new JLabel("Treatment"); gbc.gridx = 0; gbc.gridy = 3; CPanelDR.add(lblCDRTreat, gbc);
        CDRTreat = new JTextArea("", 150,2); gbc.gridx = 1; gbc.gridy = 3; CPanelDR.add(scrollTreat, gbc);

        CDRDiag.setLineWrap(true);
        scrollDiag.setViewportView(CDRDiag);
        scrollDiag.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        CDRTreat.setLineWrap(true);
        scrollTreat.setViewportView(CDRTreat);
        scrollTreat.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        CreateSubmit = new JButton("Submit"); CreateSubmit.setBounds(750,620,170,40);
        CreateSubmit.setBackground(Color.GRAY);
        CreateSubmit.addActionListener(this);

        CPanelP.setBounds(20, 60, 460, 280);
        CPanelEC.setBounds(500, 60, 460, 280);
        CPanelDR.setBounds(20, 380, 700, 280);
        CreateRecord.add(CPanelP); CreateRecord.add(CPanelEC); CreateRecord.add(CPanelDR); CreateRecord.add(CreateSubmit);
        CreateRecord.setLayout(null);

        // VIEWRECORD
        ViewRecord = new JPanel(); ViewRecord.setSize(1000, 750);
        VPanelP = new JPanel(); VPanelP.setBackground(ustYellow);
        VPatientInfo.setFont(new Font("Arial", Font.BOLD, 20)); 
        VPatientInfo.setBackground(Color.GRAY); PatientInfo.setEditable(false);
        VPanelP.setLayout(new GridBagLayout());
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 3; gbc.ipady = 15; VPanelP.add(VPatientInfo, gbc);
        lblVPLn = new JLabel("Last Name"); gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1; VPanelP.add(lblVPLn, gbc);
        VPLn = new JTextField("", 20); gbc.gridx = 1; gbc.gridy = 1; VPanelP.add(VPLn, gbc);
        lblVPGn = new JLabel("Given Name"); gbc.gridx = 0; gbc.gridy = 2; VPanelP.add(lblVPGn, gbc);
        VPGn = new JTextField("", 20); gbc.gridx = 1; gbc.gridy = 2; VPanelP.add(VPGn, gbc);
        lblVPMn = new JLabel("Middle Name"); gbc.gridx = 0; gbc.gridy = 3; VPanelP.add(lblVPMn, gbc);
        VPMn = new JTextField("", 20); gbc.gridx = 1; gbc.gridy = 3; VPanelP.add(VPMn, gbc);
        lblVPS = new JLabel("Sex (M/F"); gbc.gridx = 0; gbc.gridy = 4; VPanelP.add(lblVPS, gbc);
        VPS = new JTextField("", 20); gbc.gridx = 1; gbc.gridy = 4; VPanelP.add(VPS, gbc);
        lblVPBd = new JLabel("Date of Birth (mm/dd/yyyy)"); gbc.gridx = 0; gbc.gridy = 5; VPanelP.add(lblVPBd, gbc);
        VPBd = new JTextField("", 20); gbc.gridx = 1; gbc.gridy = 5; VPanelP.add(VPBd, gbc);
        lblVPA = new JLabel("Address"); gbc.gridx = 0; gbc.gridy = 6; VPanelP.add(lblVPA, gbc);
        VPA = new JTextField("", 20); gbc.gridx = 1; gbc.gridy = 6; VPanelP.add(VPA, gbc);

        VPanelEC = new JPanel(); VPanelEC.setBackground(ustYellow);
        VEmerCon.setFont(new Font("Arial", Font.BOLD, 20)); 
        VEmerCon.setBackground(Color.GRAY); EmerCon.setEditable(false);
        VPanelEC.setLayout(new GridBagLayout());
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 3; gbc.ipady = 15; VPanelEC.add(VEmerCon, gbc);
        lblVECLn = new JLabel("Last Name"); gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1; VPanelEC.add(lblVECLn, gbc);
        VECLn = new JTextField("", 20); gbc.gridx = 1; gbc.gridy = 1; VPanelEC.add(VECLn, gbc);
        lblVECGn = new JLabel("Given Name"); gbc.gridx = 0; gbc.gridy = 2; VPanelEC.add(lblVECGn, gbc);
        VECGn = new JTextField("", 20); gbc.gridx = 1; gbc.gridy = 2; VPanelEC.add(VECGn, gbc);
        lblVECMn = new JLabel("Middle Name"); gbc.gridx = 0; gbc.gridy = 3; VPanelEC.add(lblVECMn, gbc);
        VECMn = new JTextField("", 20); gbc.gridx = 1; gbc.gridy = 3; VPanelEC.add(VECMn, gbc);
        lblVECRel = new JLabel("Relationship to Patient"); gbc.gridx = 0; gbc.gridy = 4; VPanelEC.add(lblVECRel, gbc);
        VECRel = new JTextField("", 20); gbc.gridx = 1; gbc.gridy = 4; VPanelEC.add(VECRel, gbc);
        lblVECCn = new JLabel("Contact Number"); gbc.gridx = 0; gbc.gridy = 5; VPanelEC.add(lblVECCn, gbc);
        VECCn = new JTextField("", 20); gbc.gridx = 1; gbc.gridy = 5; VPanelEC.add(VECCn, gbc);
        lblVECA = new JLabel("Address"); gbc.gridx = 0; gbc.gridy = 6; VPanelEC.add(lblVECA, gbc);
        VECA = new JTextField("", 20); gbc.gridx = 1; gbc.gridy = 6; VPanelEC.add(VECA, gbc);

        VPanelDR = new JPanel(); VPanelDR.setBackground(ustYellow);
        VDiagRep.setFont(new Font("Arial", Font.BOLD, 20)); VDiagRep.setBackground(Color.GRAY); VDiagRep.setEditable(false);
        VPanelDR.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 5; gbc.ipady = 15; VPanelDR.add(VDiagRep, gbc);
        JScrollPane VscrollDiag = new JScrollPane(VDRDiag);
        JScrollPane VscrollTreat = new JScrollPane(VDRTreat);
        VDRDiag = new JTextArea("", 150,2); gbc.gridx = 0; gbc.gridy = 1; gbc.ipady = 75; VPanelDR.add(VscrollDiag, gbc);
        VDRTreat = new JTextArea("", 150,2); gbc.gridx = 0; gbc.gridy = 2; VPanelDR.add(VscrollTreat, gbc);
        VDRDiag.setLineWrap(true);
        VscrollDiag.setViewportView(VDRDiag);
        VscrollDiag.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        VDRTreat.setLineWrap(true);
        VscrollTreat.setViewportView(VDRTreat);
        VscrollTreat.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        VPanelP.setBounds(20, 60, 460, 280);
        VPanelEC.setBounds(500, 60, 460, 280);
        VPanelDR.setBounds(20, 380, 700, 280);

        CreateReturn = new JButton("Return"); CreateReturn.setBounds(750,620,170,40);
        CreateReturn.setBackground(Color.GRAY); 
        CreateReturn.addActionListener(this);

        ViewRecord.add(CreateReturn); ViewRecord.add(VPanelP); ViewRecord.add(VPanelDR); ViewRecord.add(VPanelEC);
        ViewRecord.setLayout(null);
        
    }

    public String PatientValidityCheck() {
        System.out.println("in ");
        try {
            System.out.println("in try");
            String input = EnterPatientID.getText();
            BufferedReader br = new BufferedReader(new FileReader(path));
            String info = br.readLine();
            String[] lineHolder = info.split(",");
            String patientInformation = "";
            String holder = lineHolder[0];
            while(info != null) {
                System.out.println("in while");
                if (input.equals(holder)) {
                    System.out.println("success");
                    remove(HomePage); add(SearchValid);
                    revalidate(); repaint();
                    return patientInformation = info;
                } else {
                    info = br.readLine();
                    lineHolder = info.split(",");
                    holder = lineHolder[0];
                    System.out.println("loop");
                }
            } 
        
        } catch (Exception PVCe) {
            PVCe.getMessage();
        }
        System.out.println("Invalid");
        remove(HomePage); add(SearchInvalid);
        revalidate(); repaint();
        return null;

    }

    public void CreateSaveRecord() {
        PatientInfo pi = new PatientInfo();
        String uID = UUID.randomUUID().toString();
        JTextArea text = new JTextArea("Patient ID: " + uID);
        JOptionPane.showMessageDialog(null, text, "Patient ID", 3);
        pi.setUniqueID(uID);
        pi.setpLname(CPLn.getText()); pi.setpFname(CPGn.getText()); pi.setpMname(CPMn.getText());
        pi.setpSex(CPS.getText()); pi.setpBday(CPBd.getText()); pi.setpAddress(CPA.getText());
        pi.setecLname(CECLn.getText()); pi.setecFname(CECGn.getText()); pi.setecMname(CECMn.getText());
        pi.setecRel(CECRel.getText()); pi.setecCn(CECCn.getText()); pi.setecAddress(CECA.getText());

        String data = pi.getUniqueID()+","+pi.getpLname()+","+pi.getpFname()+","+pi.getpMname()+","+
        pi.getpSex()+","+pi.getpBday()+","+pi.getpAddress()+","+
        pi.getecLname()+","+pi.getecFname()+","+pi.getecMname()+","+pi.getecRel()+","+pi.getecCn()+","+
        pi.getecAddress()+","+CDRDate.getText()+"\n"+CDRDiag.getText()+","+CDRTreat.getText();

        try {
            PrintWriter pw = new PrintWriter(new FileWriter(path,true));
            pw.println(data);
            pw.close();
        } catch (IOException e) {
            e.getMessage();
            e.printStackTrace();
        }
        remove(CreateRecord); remove(SearchValid);
        add(HomePage);
        revalidate(); repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource() == Create) {
                remove(HomePage);
                add(CreateRecord);
                revalidate(); repaint();
            } else if(e.getSource() == Search) {
                System.out.println("Searching");
                PatientValidityCheck();
            } else if(e.getSource() == Edit) {
                remove(SearchValid);
                add(CreateRecord);
                revalidate(); repaint();
            } else if(e.getSource() == View) {
                remove(SearchValid);
                add(ViewRecord);
                revalidate(); repaint();
                VPLn.setText("JAbolito");
                
            } else if(e.getSource() == InvalReturn) {
                remove(SearchInvalid);
                add(HomePage);
                revalidate(); repaint();                
            } else if(e.getSource() == CreateSubmit) {
                CreateSaveRecord();
            } else if(e.getSource() == CreateReturn) {
                remove(ViewRecord);
                add(HomePage);
                revalidate(); repaint();
            }
            
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
    }
    public void switchy() {
        CreateRecord.remove(CreateSubmit);
        CreateRecord.add(CreateReturn);
        revalidate(); repaint();
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
// FIX ACTIONLISTENER ON VIEW AND EDIT