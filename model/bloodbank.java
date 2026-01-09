package taskmanagement.model;

public class bloodbank {
    private String address;
    private String bankId;
    private String contactNumber;
    private String bankName;

    public bloodbank(String address, String bankId, String contactNumber, String bankName) {
        this.address = address;
        this.bankId = bankId;
        this.contactNumber = contactNumber;
        this.bankName = bankName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    
}

