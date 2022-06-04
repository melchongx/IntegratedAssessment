public class PatientInfo {
    private String pLname, pFname, pMname, pSex, pBday, pAddress;//patient
    private String ecLname, ecFname, ecMname, ecRel, ecCn, ecAddress;//emergency contact
    private String uniqueID;
    
    // setters and getters for patient
    public String getpLname() {
        return this.pLname;
    }
    public void setpLname(String pLname) {
        this.pLname = pLname;
    }
    public String getpFname() {
        return this.pFname;
    }
    public void setpFname(String pFname) {
        this.pFname = pFname;
    }
    public String getpMname() {
        return this.pMname;
    }
    public void setpMname(String pMname) {
        this.pMname = pMname;
    }
    public String getpSex() {
        return this.pSex;
    }
    public void setpSex(String pSex) {
        this.pSex = pSex;
    }
    public String getpBday() {
        return this.pBday;
    }
    public void setpBday(String pBday) {
        this.pBday = pBday;
    }
    public String getpAddress() {
        return this.pAddress;
    }
    public void setpAddress(String pAddress) {
        this.pAddress = pAddress;
    }
    public String getUniqueID() {
        return this.uniqueID;
    }
    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    // setters and getters for emergency contact
    public String getecLname() {
        return this.ecLname;
    }
    public void setecLname(String ecLname) {
        this.ecLname = ecLname;
    }
    public String getecFname() {
        return this.ecFname;
    }
    public void setecFname(String ecFname) {
        this.ecFname = ecFname;
    }
    public String getecMname() {
        return this.ecMname;
    }
    public void setecMname(String ecMname) {
        this.ecMname = ecMname;
    }
    public String getecRel() {
        return this.ecRel;
    }
    public void setecRel(String ecRel) {
        this.ecRel = ecRel;
    }
    public String getecCn() {
        return this.ecAddress;
    }
    public void setecCn(String ecCn) {
        this.ecCn = ecCn;
    }
    public String getecAddress() {
        return this.ecAddress;
    }
    public void setecAddress(String ecAddress) {
        this.ecAddress = ecAddress;
    }
    // behaviour-method
    public void showPatientDetails() {
        System.out.println("Last Name: " + pLname);
        System.out.println("Given Name: " + pFname);
        System.out.println("Middle Name: " + pMname);
        System.out.println("Sex: " + pSex);
        System.out.println("Date of Birth (mm/dd/yyyy): " + pBday);
        System.out.println("Address: " + pAddress);
    }

    public void showEContactDetails() {
        System.out.println("Last Name: " + ecLname);
        System.out.println("Given Name: " + ecFname);
        System.out.println("Middle Name: " + ecMname);
        System.out.println("Sex: " + ecRel);
        System.out.println("Date of Birth (mm/dd/yyyy): " + ecCn);
        System.out.println("Address: " + ecAddress);
    }

    
}
