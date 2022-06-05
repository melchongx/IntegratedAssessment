import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
import java.text.BreakIterator;
import java.util.UUID;

public class TestComputer extends JFrame implements ActionListener {
    JPanel HomePage, SearchValid, SearchInvalid, CreateRecord, ViewRecord; //main panels
    JPanel HPPanel, VSearch, ISearch, CPanelP, CPanelEC, CPanelDR, VPanelP, VPanelEC, VPanelDR; //subpanels for main panels
    JTextField EnterPatientID;
    JLabel HomePrompt1, HomePrompt2, ValSearchPrompt, InvalSearchPrompt1,InvalSearchPrompt2;
    JLabel lblCPLn, lblCPGn, lblCPMn, lblCPS, lblCPBd, lblCPA, lblCECLn, lblCECGn, lblCECMn, lblCECRel, lblCECCn, lblCECA, lblCDRDate, lblCDRDiag, lblCDRTreat; //labels for create/edit record
    JLabel lblVPLn, lblVPGn, lblVPMn, lblVPS, lblVPBd, lblVPA, lblVECLn, lblVECGn, lblVECMn, lblVECRel, lblVECCn, lblVECA, lblVDRDate, lblVDRDiag, lblVDRTreat; //labels for view record
    JTextField CPLn, CPGn, CPMn, CPS, CPBd, CPA, CECLn, CECGn, CECMn, CECRel, CECCn, CECA, CDRDate; //textfields for create/edit record
    JTextField VPLn, VPGn, VPMn, VPS, VPBd, VPA, VECLn, VECGn, VECMn, VECRel, VECCn, VECA, VDRDate; //textfields for view record
    JTextArea CDRDiag, CDRTreat, VDRDiag, VDRTreat; // textareas for view record
    JButton Search, Create, View, Edit, InvalReturn, CreateSubmit, CreateReturn;
    GridBagConstraints gbc = new GridBagConstraints(); //constraints for layout manager(gridbag layout)
    Color ustYellow = new Color(254,192,15); //custom color
    Border mainBorder = BorderFactory.createLineBorder(Color.BLACK, 10);
    JTextField HTitle = new JTextField("UST MEDICAL RECORDS INTERFACE"); //title for homepage
    JTextField SVTitle = new JTextField("UST MEDICAL RECORDS INTERFACE"); //title for validsearch
    JTextField SITitle = new JTextField("UST MEDICAL RECORDS INTERFACE"); //title for invalidsearch
    JTextField PatientInfo = new JTextField("PATIENT INFORMATION"); //create/edit record patient title
    JTextField VPatientInfo = new JTextField("PATIENT INFORMATION"); //view record patient title
    JTextField EmerCon = new JTextField("EMERGENCY CONTACT"); //create/edit record title
    JTextField VEmerCon = new JTextField("EMERGENCY CONTACT"); //view record title
    JTextField DiagRep = new JTextField("DIAGNOSIS REPORT"); //create/edit record
    JTextField VDiagRep = new JTextField("DIAGNOSIS REPORT"); //view record
        
    static String uHome = System.getProperty("user.home");
    static String fSeparator = System.getProperty("file.separator");
    static String path = uHome + fSeparator + "ustMedRec.csv";

    public static void myFile() { //static to be accessible throught the class
        File myFile = new File(path);
        System.out.print(path);
    }
    
    public TestComputer() { 
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
        VPanelP.setLayout(new GridBagLayout()); VPatientInfo.setEditable(false);
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
        VPLn.setEditable(false); VPGn.setEditable(false); VPMn.setEditable(false);
        VPS.setEditable(false); VPBd.setEditable(false); VPA.setEditable(false);

        VPanelEC = new JPanel(); VPanelEC.setBackground(ustYellow);
        VEmerCon.setFont(new Font("Arial", Font.BOLD, 20)); 
        VEmerCon.setBackground(Color.GRAY); EmerCon.setEditable(false);
        VPanelEC.setLayout(new GridBagLayout()); VEmerCon.setEditable(false);
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
        VECLn.setEditable(false); VECGn.setEditable(false); VECMn.setEditable(false);
        VECRel.setEditable(false); VECCn.setEditable(false); VECA.setEditable(false);

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
        VDRDiag.setEditable(false); VDRTreat.setEditable(false);
        
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
                    return info;
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
        pi.getecAddress()+","+CDRDiag.getText()+": "+CDRDate.getText()+"// ,"+CDRTreat.getText()+": "+CDRDate.getText()+"// ";

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
                CPLn.setText(""); CPGn.setText(""); CPMn.setText(""); CPS.setText(""); CPBd.setText(""); CPA.setText("");
                CECLn.setText(""); CECGn.setText(""); CECMn.setText(""); CECRel.setText(""); CECCn.setText(""); CECA.setText("");
                CDRDate.setText(""); CDRDiag.setText(""); CDRTreat.setText("");
                revalidate(); repaint();
            } else if(e.getSource() == Search) {
                System.out.println("Searching");
                String holder = PatientValidityCheck();
                String holderS[] = holder.split(",");
                if(EnterPatientID.getText().equals(holderS[0])) {
                    remove(HomePage);
                    add(SearchValid);
                    revalidate(); repaint();
                }
            } else if(e.getSource() == Edit) {
                remove(SearchValid);
                add(CreateRecord);
                String holder = PatientValidityCheck();
                String holderS[] = holder.split(",");
                CPLn.setText(holderS[1]); CPGn.setText(holderS[2]); CPMn.setText(holderS[3]); CPS.setText(holderS[4]); CPBd.setText(holderS[5]); CPA.setText(holderS[6]);
                CECLn.setText(holderS[7]); CECGn.setText(holderS[8]); CECMn.setText(holderS[9]); CECRel.setText(holderS[10]); CECCn.setText(holderS[11]); CECA.setText(holderS[12]);
                CDRDate.setText(""); CDRDiag.setText(holderS[13]); CDRTreat.setText(holderS[14]);

                revalidate(); repaint();
            } else if(e.getSource() == View) {
                remove(SearchValid);
                add(ViewRecord);
                String holder = PatientValidityCheck();
                String holderS[] = holder.split(",");
                VPLn.setText(holderS[1]); VPGn.setText(holderS[2]); VPMn.setText(holderS[3]); VPS.setText(holderS[4]); VPBd.setText(holderS[5]); VPA.setText(holderS[6]);
                VECLn.setText(holderS[7]); VECGn.setText(holderS[8]); VECMn.setText(holderS[9]); VECRel.setText(holderS[10]); VECCn.setText(holderS[11]); VECA.setText(holderS[12]);
                VDRDiag.setText(holderS[13]); VDRTreat.setText(holderS[14]);
                ViewRecord.revalidate(); ViewRecord.repaint();
                revalidate(); repaint();
            } else if(e.getSource() == InvalReturn) {
                remove(SearchInvalid);
                add(HomePage);
                revalidate(); repaint();                
            } else if(e.getSource() == CreateSubmit) {
                if(CPLn.getText().equals("")||CPGn.getText().equals("")||CPMn.getText().equals("")|| CPS.getText().equals("")||CPBd.getText().equals("")||CPA.getText().equals("")||CECLn.getText().equals("")||CECGn.getText().equals("")||CECMn.getText().equals("")||CECRel.getText().equals("")||CECCn.getText().equals("")||CECA.getText().equals("")||CDRDate.getText().equals("")||CDRDiag.getText().equals("")||CDRTreat.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill out all required information");
                    
                } else {
                    if(CPS.getText().equals("M")||CPS.getText().equals("m")||CPS.getText().equals("F")||CPS.getText().equals("f")) {
                        CreateSaveRecord();
                    } else {
                        JOptionPane.showMessageDialog(null, "Only acceptable options for Patient Sex: M/F");
                    }
                }
            } else if(e.getSource() == CreateReturn) {
                remove(ViewRecord);
                VPLn.setText(""); VPGn.setText(""); VPMn.setText(""); VPS.setText(""); VPBd.setText(""); VPA.setText("");
                VECLn.setText(""); VECGn.setText(""); VECMn.setText(""); VECRel.setText(""); VECCn.setText(""); VECA.setText("");
                VDRDiag.setText(""); VDRTreat.setText("");
                add(HomePage);
                revalidate(); repaint();
            }
            
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
    }
    public static void main(String[] args) {
        myFile();
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(path,true));
            pw.println("123456,Dela Cruz,Juan,Santos,M,01/01/2001,123 J Bernardo St Manila,Dela Cruz,Jose,Santos,Brother,09091234567,123 J Bernardo St Manila,Fever: 5/31/2022,Biogesic: 5/31/2022");
            pw.close();
        } catch (IOException eww) {
            eww.getMessage();
        }
        TestComputer tc = new TestComputer();
        tc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}