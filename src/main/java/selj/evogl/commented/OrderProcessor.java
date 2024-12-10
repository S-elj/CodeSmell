package selj.evogl.commented;


// Processeur de commande avec injection de dépendances
public class OrderProcessor {
    private final IInventoryManager inventoryManager;
    private final IPaymentProcessor paymentProcessor;
    private final IShippingService shippingService;
    private final INotificationService notificationService;
    private final ICustomerDatabase customerDatabase;

    // Constructeur avec injection de dépendances
    public OrderProcessor(
            IInventoryManager inventoryManager,
            IPaymentProcessor paymentProcessor,
            IShippingService shippingService,
            INotificationService notificationService,
            ICustomerDatabase customerDatabase
    ) {
        this.inventoryManager = inventoryManager;
        this.paymentProcessor = paymentProcessor;
        this.shippingService = shippingService;
        this.notificationService = notificationService;
        this.customerDatabase = customerDatabase;
    }

    // Méthode processOrder simplifiée et plus modulaire
    public boolean processOrder(String orderId, String customerId) {
        try {
            // Récupération du client
            Customer customer = customerDatabase.getCustomer(customerId);

            // Vérification du stock
            if (!inventoryManager.checkStock(orderId)) {
                System.out.println("Stock non disponible");
                return false;
            }

            // Calcul du montant
            double amount = inventoryManager.getOrderAmount(orderId);

            // Traitement du paiement
            if (!paymentProcessor.processPayment(customer.getCreditCard(), amount)) {
                System.out.println("Échec du paiement");
                return false;
            }

            // Mise à jour du stock
            inventoryManager.updateStock(orderId);

            // Création de l'expédition
            String trackingNumber = shippingService.createShipment(orderId, customer.getAddress());

            // Envoi de la notification
            notificationService.sendConfirmation(customer.getEmail(), orderId, trackingNumber);

            System.out.println("Commande traitée avec succès");
            return true;

        } catch (Exception e) {
            System.err.println("Erreur lors du traitement de la commande : " + e.getMessage());
            return false;
        }
    }
}