package selj.evogl.commented;


// Version 2 - Avec commentaires explicatifs
/* CODE SMELL: Couplage fort entre objets (High Coupling)
 * Problèmes identifiés:
 * 1. OrderProcessor crée directement toutes ses dépendances (new XxxService())
 * 2. OrderProcessor dépend de trop de classes concrètes
 * 3. La classe est difficile à tester car on ne peut pas mocker les dépendances
 * 4. Modification d'une dépendance peut affecter OrderProcessor
 *
 * Solutions proposées:
 * 1. Utiliser l'injection de dépendances
 * 2. Créer des interfaces pour les services
 * 3. Appliquer le principe d'inversion des dépendances
 */
class OrderProcessor {
    private InventoryManager inventoryManager;
    private PaymentProcessor paymentProcessor;
    private ShippingService shippingService;
    private NotificationService notificationService;
    private CustomerDatabase customerDatabase;

    // PROBLÈME: Construction directe des dépendances = couplage fort
    public OrderProcessor() {
        this.inventoryManager = new InventoryManager();
        this.paymentProcessor = new PaymentProcessor();
        this.shippingService = new ShippingService();
        this.notificationService = new NotificationService();
        this.customerDatabase = new CustomerDatabase();
    }

    // PROBLÈME: Méthode trop complexe qui utilise directement toutes les dépendances
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