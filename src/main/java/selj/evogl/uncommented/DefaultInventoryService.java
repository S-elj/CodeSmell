package selj.evogl.uncommented;

public class DefaultInventoryService implements InventoryService {
    @Override
    public boolean checkStock(String orderId) {
        // Mimics the original InventoryManager checkStock method
        return true;
    }

    @Override
    public double calculateOrderAmount(String orderId) {
        // Mimics the original InventoryManager getOrderAmount method
        return 100.0;
    }

    @Override
    public void updateStock(String orderId) {
        // Mimics the original InventoryManager updateStock method
        // In a real implementation, this would update inventory
        System.out.println("Updating stock for order: " + orderId);
    }
}