package selj.evogl.uncommented;

public interface NotificationService {
    void sendOrderConfirmation(String email, String orderId, String trackingNumber);
}