package selj.evogl.human;

public interface IPaymentService {
    boolean processPayment(String creditCard, double amount);
}