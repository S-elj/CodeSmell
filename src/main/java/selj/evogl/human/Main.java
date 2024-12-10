package selj.evogl.human;

class Main {
    public static void main(String[] args) {
        OrderService processor = new OrderService();
        processor.processOrder("ORDER123", "CUST456");
        System.out.println("Ordre traité avec succès");
    }
}