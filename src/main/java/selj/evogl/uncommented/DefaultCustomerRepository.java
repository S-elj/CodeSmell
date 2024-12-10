package selj.evogl.uncommented;

public class DefaultCustomerRepository implements CustomerRepository {
    @Override
    public Customer findById(String customerId) {
        // Mimics the original CustomerDatabase behavior
        return new Customer.Builder()
                .id(customerId)
                .email("customer@example.com")
                .address("123 Sample Street")
                .creditCard("1234567890123456")
                .build();
    }
}