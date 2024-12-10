package selj.evogl.commented;

public interface IInventoryManager {
    boolean checkStock(String orderId);
    double getOrderAmount(String orderId);
    void updateStock(String orderId);
}