package selj.evogl.base;

class OrderProcessor {
    private InventoryManager inventoryManager;
    private PaymentProcessor paymentProcessor;
    private ShippingService shippingService;
    private NotificationService notificationService;
    private CustomerDatabase customerDatabase;

    public OrderProcessor() {
        this.inventoryManager = new InventoryManager();
        this.paymentProcessor = new PaymentProcessor();
        this.shippingService = new ShippingService();
        this.notificationService = new NotificationService();
        this.customerDatabase = new CustomerDatabase();
    }

    public void processOrder(String orderId, String customerId) {
        Customer customer = customerDatabase.getCustomer(customerId);
        boolean hasStock = inventoryManager.checkStock(orderId);

        if (hasStock) {
            System.out.println("Stock available");
            double amount = inventoryManager.getOrderAmount(orderId);
            boolean paymentSuccess = paymentProcessor.processPayment(customer.getCreditCard(), amount);

            if (paymentSuccess) {
                System.out.println("Successfully processed payment for order " + orderId);
                inventoryManager.updateStock(orderId);
                String trackingNumber = shippingService.createShipment(orderId, customer.getAddress());
                notificationService.sendConfirmation(customer.getEmail(), orderId, trackingNumber);
            }
        }
    }
}