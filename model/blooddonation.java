package taskmanagement.model;

public class blooddonation {
    private String donorId;
    private String donationDate;
    private double quantity;
    private String donationId;
    private String bloodType;

    public blooddonation(String donorId, String donationDate, double quantity, String donationId, String bloodType) {
        this.donorId = donorId;
        this.donationDate = donationDate;
        this.quantity = quantity;
        this.donationId = donationId;
        this.bloodType = bloodType;
    }

    public String getDonorId() {
        return donorId;
    }

    public void setDonorId(String donorId) {
        this.donorId = donorId;
    }

    public String getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(String donationDate) {
        this.donationDate = donationDate;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getDonationId() {
        return donationId;
    }

    public void setDonationId(String donationId) {
        this.donationId = donationId;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
    
}
