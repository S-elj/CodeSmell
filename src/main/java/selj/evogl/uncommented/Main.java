package selj.evogl.uncommented;

class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        processor.processOrder("ORDER123", "CUST456");
        System.out.println("Ordre traité avec succès");
    }
}