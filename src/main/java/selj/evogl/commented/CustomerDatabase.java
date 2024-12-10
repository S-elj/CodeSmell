package selj.evogl.commented;

public class CustomerDatabase implements ICustomerDatabase {
    public Customer getCustomer(String customerId) {
        // Récupération du client
        return new Customer(
                customerId,
                "client@example.com",
                "Carte de crédit",
                "Adresse de livraison"
        );
    }
}
