package selj.evogl.human;

class OrderService implements IOrderService {
    private IInventoryService inventoryManager;
    private IPaymentService paymentService;
    private IShippingService shippingService;
    private INotificationService notificationService;
    private ICustomerRepository customerRepository;

    public OrderService(IInventoryService inventoryManager, IPaymentService paymentService,
                        IShippingService shippingService, INotificationService notificationService,
                        ICustomerRepository customerRepository) {
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