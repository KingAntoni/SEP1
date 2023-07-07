package Model;

public class Customer {
    private String name;
    private String phoneNumber;
    private String email;
    private int numberOfReservations;

    public Customer(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.numberOfReservations = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumberOfReservations() {
        return numberOfReservations;
    }

    public void setNumberOfReservations(int numberOfReservations) {
        this.numberOfReservations = numberOfReservations;
    }
}