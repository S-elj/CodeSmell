package selj.evogl.commented;

public interface IPaymentProcessor {
    boolean processPayment(String creditCard, double amount);
}