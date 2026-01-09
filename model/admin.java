package taskmanagement.model;
public class admin extends person{
    private int adminId;
    private String position;

    public admin(String email, String name, String cnic, int age, String gender, String contactNo, int adminId, String position) {
        super(email, name, age, gender, contactNo);
        this.adminId = adminId;
        this.position = position;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
