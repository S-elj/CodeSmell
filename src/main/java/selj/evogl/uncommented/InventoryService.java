package selj.evogl.uncommented;

public interface InventoryService {
    boolean checkStock(String orderId);
    double calculateOrderAmount(String orderId);
    void updateStock(String orderId);
}
