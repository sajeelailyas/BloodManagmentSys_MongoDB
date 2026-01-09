package taskmanagement.model;

public class person {
    private String name;
    private String cnic;
    private int age;
    private String gender;
    private String contactNo;
    
    // Default constructor
    public person() {
        // Initialize instance variables with default values
        this.name = "";
        this.cnic = "";
        this.age = 0;
        this.gender = "";
        this.contactNo = "";
    }
    
    // Parameterized constructor
    public person(String name, String cnic, int age, String gender, String contactNo) {
        this.name = name;
        this.cnic = cnic;
        this.age = age;
        this.gender = gender;
        this.contactNo = contactNo;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getCnic() {
        return cnic;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
}
