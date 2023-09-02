package comc.proj.entity;

public class Users {
    String companyName,businessSector,companyLocation,contactName
            ,contactJobTitle,contactEmail,contactTelephone,userName,password,numberOfEmployees;
    int id,scores;
    public String getCompanyName() {
        return companyName;
    }

    public String getBusinessSector() {
        return businessSector;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactJobTitle() {
        return contactJobTitle;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getContactTelephone() {
        return contactTelephone;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public int getScores() {
        return scores;
    }

    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setBusinessSector(String businessSector) {
        this.businessSector = businessSector;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setContactJobTitle(String contactJobTitle) {
        this.contactJobTitle = contactJobTitle;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public void setContactTelephone(String contactTelephone) {
        this.contactTelephone = contactTelephone;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    public void setNumberOfEmployees(String numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }
    public Users(String companyName, String businessSector, String companyLocation, String contactName, String contactJobTitle, String contactEmail, String contactTelephone, String userName, String password,  String numberOfEmployees) {
        this.companyName = companyName;
        this.businessSector = businessSector;
        this.companyLocation = companyLocation;
        this.contactName = contactName;
        this.contactJobTitle = contactJobTitle;
        this.contactEmail = contactEmail;
        this.contactTelephone = contactTelephone;
        this.userName = userName;
        this.password = password;
        this.numberOfEmployees = numberOfEmployees;
    }




}
