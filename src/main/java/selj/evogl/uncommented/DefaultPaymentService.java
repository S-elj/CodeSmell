package selj.evogl.uncommented;

public class DefaultPaymentService implements PaymentService {
    @Override
    public boolean processPayment(String creditCard, double amount) {
        // Mimics the original PaymentProcessor behavior
        System.out.println("Processing payment of " + amount + " with credit card");
        return true;
    }
}
