package user;

public abstract interface User {

    public abstract void createAccount(String firstName, String lastName, String email, String username,
            String password,
            int phoneNumber, String location, String customerId, String role, String status);

    public abstract void signIn(String username, String password);
}
