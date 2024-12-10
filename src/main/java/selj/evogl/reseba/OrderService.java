package selj.evogl.reseba;

class OrderService {
    private InventoryService inventoryManager;
    private PaymentService paymentService;
    private ShippingService shippingService;
    private NotificationService notificationService;
    private CustomerRepository customerRepository;

    public OrderService(InventoryService inventoryManager, PaymentService paymentService,
                        ShippingService shippingService, NotificationService notificationService,
                        CustomerRepository customerRepository) {
        this.inventoryManager = inventoryManager;
        this.paymentService = paymentService;
        this.shippingService = shippingService;
        this.notificationService = notificationService;
        this.customerRepository = customerRepository;
    }

    public OrderService() {
        this.inventoryManager = new InventoryService();
        this.paymentService = new PaymentService();
        this.shippingService = new ShippingService();
        this.notificationService = new NotificationService();
        this.customerRepository = new CustomerRepository();
    }

    public void processOrder(String orderId, String customerId) {
        Customer customer = customerRepository.getCustomer(customerId);
        boolean hasStock = inventoryManager.checkStock(orderId);

        if (!hasStock) return;

        System.out.println("Stock available");
        double amount = inventoryManager.getOrderAmount(orderId);
        boolean paymentSuccess = paymentService.processPayment(customer.getCreditCard(), amount);
        if (!paymentSuccess) return;

        System.out.println("Successfully processed payment for order " + orderId);
        inventoryManager.updateStock(orderId);
        String trackingNumber = shippingService.createShipment(orderId, customer.getAddress());
        notificationService.sendConfirmation(customer.getEmail(), orderId, trackingNumber);
    }
}