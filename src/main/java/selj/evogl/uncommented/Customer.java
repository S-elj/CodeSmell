package selj.evogl.uncommented;

// Improved Customer class with validation
public class Customer {
    private final String id;
    private final String email;
    private final String address;
    private final String creditCard;

    private Customer(Builder builder) {
        this.id = builder.id;
        this.email = validateEmail(builder.email);
        this.address = validateAddress(builder.address);
        this.creditCard = validateCreditCard(builder.creditCard);
    }

    // Validation methods
    private String validateEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        return email;
    }

    private String validateAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty");
        }
        return address;
    }

    private String validateCreditCard(String creditCard) {
        if (creditCard == null || !creditCard.matches("\\d{16}")) {
            throw new IllegalArgumentException("Invalid credit card number");
        }
        return creditCard;
    }

    // Builder pattern for flexible object creation
    public static class Builder {
        private String id;
        private String email;
        private String address;
        private String creditCard;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder creditCard(String creditCard) {
            this.creditCard = creditCard;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

    // Getters
    public String getId() { return id; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public String getCreditCard() { return creditCard; }
}
