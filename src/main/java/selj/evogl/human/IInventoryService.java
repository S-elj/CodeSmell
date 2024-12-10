package selj.evogl.human;

public interface IInventoryService {
    boolean checkStock(String orderId);
    double getOrderAmount(String orderId);
    void updateStock(String orderId);
}