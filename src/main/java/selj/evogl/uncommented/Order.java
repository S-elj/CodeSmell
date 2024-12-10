package selj.evogl.uncommented;


// Value object for Order details
class Order {
    private final String orderId;
    private final double amount;

    public Order(String orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;
    }

    public String getOrderId() { return orderId; }
    public double getAmount() { return amount; }
}