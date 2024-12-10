package selj.evogl.uncommented;

public class DefaultShippingService implements ShippingService {
    @Override
    public String createShipment(String orderId, String address) {
        // Generates a tracking number and creates a shipment
        String trackingNumber = "TRACK-" + orderId;
        System.out.println("Creating shipment for order: " + orderId + " to " + address);
        return trackingNumber;
    }
}