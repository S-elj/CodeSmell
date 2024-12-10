package selj.evogl.commented;

public interface INotificationService {
    void sendConfirmation(String email, String orderId, String trackingNumber);
}