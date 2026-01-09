package taskmanagement.model;

public class notification {
    private String notificationId;
    private String notificationData;
    private String status;
    private String message;

    public notification(String notificationId, String notificationData, String status, String message) {
        this.notificationId = notificationId;
        this.notificationData = notificationData;
        this.status = status;
        this.message = message;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public String getNotificationData() {
        return notificationData;
    }

    public void setNotificationData(String notificationData) {
        this.notificationData = notificationData;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
