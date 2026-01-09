package taskmanagement.model;

public class bloodtransfusion {
    private String donationId;
    private String transfusionId;
    private String transfusionDate;

    public bloodtransfusion(String donationId, String transfusionId, String transfusionDate) {
        this.donationId = donationId;
        this.transfusionId = transfusionId;
        this.transfusionDate = transfusionDate;
    }

    public String getDonationId() {
        return donationId;
    }

    public void setDonationId(String donationId) {
        this.donationId = donationId;
    }

    public String getTransfusionId() {
        return transfusionId;
    }

    public void setTransfusionId(String transfusionId) {
        this.transfusionId = transfusionId;
    }

    public String getTransfusionDate() {
        return transfusionDate;
    }

    public void setTransfusionDate(String transfusionDate) {
        this.transfusionDate = transfusionDate;
    }
    
}

