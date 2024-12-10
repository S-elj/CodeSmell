package selj.evogl.human;

public class InventoryService implements IInventoryService {
    public boolean checkStock(String orderId) { return true; }
    public double getOrderAmount(String orderId) { return 100.0; }
    public void updateStock(String orderId) { }
}
