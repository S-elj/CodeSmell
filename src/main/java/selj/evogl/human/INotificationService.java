package selj.evogl.human;

public interface INotificationService {
    void sendConfirmation(String email, String orderId, String trackingNumber);
}