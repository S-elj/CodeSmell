package selj.evogl.commented;

public class ShippingService implements IShippingService {
    public String createShipment(String orderId, String address) {
        // Création d'un numéro de suivi
        return "TN" + System.currentTimeMillis();
    }
}