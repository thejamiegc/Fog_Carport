package dat.backend.model.entities;

import java.util.Objects;

public class User {
    // VARIABLES
    private int userID;
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private int postalcode;
    private int phonenumber;
    private String city;
    private String password;
    private String role;

    // CONSTRUCTOR
    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
    // CONSTRUCTOR
    public User(String firstname, String lastname, String email, String password, String address, int postalcode, int phonenumber, String role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.postalcode = postalcode;
        this.phonenumber = phonenumber;
        this.role = role;
    }
    // CONSTRUCTOR
    public User(int userID, String firstname, String lastname, String email, String password, String address, int postalcode, int phonenumber, String role) {
        this.userID = userID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.postalcode = postalcode;
        this.phonenumber = phonenumber;
        this.role = role;
    }
    // CONSTRUCTOR
    public User(String firstname, String lastname, String email, String address, int postalcode, int phonenumber, String city) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.postalcode = postalcode;
        this.phonenumber = phonenumber;
        this.city = city;
    }

    // GETTERS
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getAddress() {
        return address;
    }

    public int getPostalcode() {
        return postalcode;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public int getUserID() {
        return userID;
    }

    public String getCity() {
        return city;
    }


    // SETTERS
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostalcode(int postalcode) {
        this.postalcode = postalcode;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getEmail().equals(user.getEmail()) && getPassword().equals(user.getPassword()) &&
                getRole().equals(user.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getPassword(), getRole());
    }

    @Override
    public String toString() {
        return "User{" +
                "brugerNavn='" + email + '\'' +
                ", kodeord='" + password + '\'' +
                ", rolle='" + role + '\'' +
                '}';
    }
}