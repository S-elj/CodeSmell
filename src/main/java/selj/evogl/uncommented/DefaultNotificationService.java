package selj.evogl.uncommented;

public class DefaultNotificationService implements NotificationService {
    @Override
    public void sendOrderConfirmation(String email, String orderId, String trackingNumber) {
        // Sends order confirmation
        System.out.println("Sending confirmation to " + email +
                " for order " + orderId +
                " with tracking number " + trackingNumber);
    }
}