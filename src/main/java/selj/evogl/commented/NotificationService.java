package selj.evogl.commented;

public class NotificationService implements INotificationService {
    public void sendConfirmation(String email, String orderId, String trackingNumber) {
        // Envoie une notification
        System.out.println("Notification envoyée à " + email);
    }
}