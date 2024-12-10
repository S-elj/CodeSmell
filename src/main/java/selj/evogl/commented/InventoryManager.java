package selj.evogl.commented;

// Implémentations concrètes (peuvent être remplacées facilement)
public class InventoryManager implements IInventoryManager {
    public boolean checkStock(String orderId) {
        // Implémentation réelle
        return true;
    }

    public double getOrderAmount(String orderId) {
        // Implémentation réelle
        return 100.0;
    }

    public void updateStock(String orderId) {
        // Mise à jour du stock
    }
}
