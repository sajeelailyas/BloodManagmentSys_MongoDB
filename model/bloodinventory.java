package taskmanagement.model;

public class bloodinventory {
    private String inventoryId;
    private String bloodType;
    private double quantityAvailable;

    public bloodinventory(String inventoryId, String bloodType, double quantityAvailable) {
        this.inventoryId = inventoryId;
        this.bloodType = bloodType;
        this.quantityAvailable = quantityAvailable;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public double getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(double quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }
    
}

