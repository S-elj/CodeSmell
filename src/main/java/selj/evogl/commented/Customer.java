package selj.evogl.commented;

// Classe de client simplifié
public class Customer {
    private String id;
    private String email;
    private String creditCard;
    private String address;

    public Customer(String id, String email, String creditCard, String address) {
        this.id = id;
        this.email = email;
        this.creditCard = creditCard;
        this.address = address;
    }

    public String getEmail() { return email; }
    public String getCreditCard() { return creditCard; }
    public String getAddress() { return address; }
}