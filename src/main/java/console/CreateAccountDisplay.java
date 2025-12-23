package console;

import java.util.Scanner;

public class CreateAccountDisplay {
    private String firstName;
    private String lastName;
    // private String email;
    private String username;
    private String password;
    private int phoneNumber;
    private String location;

    Scanner scanner = new Scanner(System.in);

    public CreateAccountDisplay() {
        System.out.print("Please enter your firstName: ");
        this.firstName = scanner.nextLine();
        System.out.print("Please enter your lastName: ");
        this.lastName = scanner.nextLine();
        System.out.print("Please enter your username: ");
        this.username = scanner.nextLine();
        System.out.print("Please enter your password: ");
        this.password = scanner.nextLine();
        System.out.print("Please enter your phoneNumber: ");
        this.phoneNumber = scanner.nextInt();
        System.out.print("Please enter your location (US/UK/FR/IT): ");
        this.location = scanner.nextLine();
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getLocation() {
        return location;
    }

}
