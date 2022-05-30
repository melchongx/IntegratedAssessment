public class PatientInfo {
    String pLname, pFname, pMname, pSex, pBday, pAddress;
    int uniqueID;
    
    // setters and getters
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
    public String getSex() {
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
    public int getUniqueID() {
        return this.uniqueID;
    }
    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
    }
    // behaviour-method
    public void showDetails() {
        System.out.println("Last Name: " + pLname);
        System.out.println("Given Name: " + pFname);
        System.out.println("Middle Name: " + pMname);
        System.out.println("Sex: " + pSex);
        System.out.println("Date of Birth (mm/dd/yyyy): " + pBday);
        System.out.println("Address: " + pAddress);
    }

}
