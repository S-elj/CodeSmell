package selj.evogl.uncommented;

class OrderProcessor {
    private InventoryService inventoryService;
    private PaymentService paymentService;
    private ShippingService shippingService;
    private NotificationService notificationService;
    private CustomerRepository customerRepository;

    public OrderProcessor() {
        this.inventoryService = new DefaultInventoryService();
        this.paymentService = new DefaultPaymentService();
        this.shippingService = new DefaultShippingService();
        this.notificationService = new DefaultNotificationService();
        this.customerRepository = new DefaultCustomerRepository();
    }

    public void processOrder(String orderId, String customerId) {
        Customer customer = customerRepository.findById(customerId);
        boolean hasStock = inventoryService.checkStock(orderId);

        if (hasStock) {
            System.out.println("Stock available");
            double amount = inventoryService.calculateOrderAmount(orderId);
            boolean paymentSuccess = paymentService.processPayment(customer.getCreditCard(), amount);

            if (paymentSuccess) {
                System.out.println("Successfully processed payment for order " + orderId);
                inventoryService.updateStock(orderId);
                String trackingNumber = shippingService.createShipment(orderId, customer.getAddress());
                notificationService.sendOrderConfirmation(customer.getEmail(), orderId, trackingNumber);
            }
        }
    }
}