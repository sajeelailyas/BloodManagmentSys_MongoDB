package taskmanagement.model;

public class donor extends person {
    private String bloodType;
    private int quantity;
    private String city;

    public donor() {
        super();
        bloodType = "A+";
        quantity = 0;
        city = "";
    }

    public donor(String name, String cnic, int age, String gender, String contactNo, String bloodType, int quantity, String city) {
        super(name, cnic, age, gender, contactNo);
        this.bloodType = bloodType;
        this.quantity = quantity;
        this.city = city;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
