package selj.evogl.commented;

// Les autres classes restent identiques...
class Customer {
    private String id;
    private String email;
    private String address;
    private String creditCard;

    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public String getCreditCard() { return creditCard; }
}

class InventoryManager {
    public boolean checkStock(String orderId) { return true; }
    public double getOrderAmount(String orderId) { return 100.0; }
    public void updateStock(String orderId) { }
}

class PaymentProcessor {
    public boolean processPayment(String creditCard, double amount) { return true; }
}

class ShippingService {
    public String createShipment(String orderId, String address) { return "TN123456"; }
}

class NotificationService {
    public void sendConfirmation(String email, String orderId, String trackingNumber) { }
}

class CustomerDatabase {
    public Customer getCustomer(String customerId) { return new Customer(); }
}