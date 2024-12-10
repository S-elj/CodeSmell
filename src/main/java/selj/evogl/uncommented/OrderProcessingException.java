package selj.evogl.uncommented;

// Improved exception handling
class OrderProcessingException extends RuntimeException {
    public OrderProcessingException(String message) {
        super(message);
    }
}