package user;

public class Customer implements User {
    private String customerId;
    String location;
    String role;
    String status;

    public Customer(String firstName, String lastName, String email, String username, String password,
            int phoneNumber, String location) {
        this.customerId = generateCustomerId(firstName, lastName);
        this.location = location;
        this.role = "customer";
        this.status = "active";
        createAccount(firstName, lastName, email, username, password, phoneNumber, location, customerId, role, status);
    }

    public String getCustomerId() {
        return customerId;
    }

    private String generateCustomerId(String firstName, String lastName) {
        String combined = firstName.substring(0, 3) + lastName.substring(0, 3) + System.currentTimeMillis();
        String customerId = "CUST" + combined.toUpperCase();
        return customerId;
    }

    public void createAccount(String firstName, String lastName, String email, String username, String password,
            int phoneNumber, String location, String customerId, String role, String status) {
        /** To do: Create account implementation */
    }

    public void signIn(String username, String password) {
        /** To do: Sign in implementation */
    }

}
