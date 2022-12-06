package dat.backend.model.entities;

import java.sql.Timestamp;

public class Order {
    int orderID;
    int employeeID;
    int customerID;
    Timestamp created;
    int carportID;
    double price;
    int statusID;
    String bom;

    public Order(int orderID, int employeeID, int customerID, Timestamp created, int carportID, double price, int statusID, String bom) {
        this.orderID = orderID;
        this.employeeID = employeeID;
        this.customerID = customerID;
        this.created = created;
        this.carportID = carportID;
        this.price = price;
        this.statusID = statusID;
        this.bom = bom;
    }

    public Order(int employeeID, int customerID, Timestamp created, int carportID, double price, int statusID, String bom) {
        this.employeeID = employeeID;
        this.customerID = customerID;
        this.created = created;
        this.carportID = carportID;
        this.price = price;
        this.statusID = statusID;
        this.bom = bom;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public Timestamp getCreated() {
        return created;
    }

    public int getCarportID() {
        return carportID;
    }

    public double getPrice() {
        return price;
    }

    public int getStatusID() {
        return statusID;
    }

    public String getBom() {
        return bom;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", employeeID=" + employeeID +
                ", customerID=" + customerID +
                ", created=" + created +
                ", carportID=" + carportID +
                ", price=" + price +
                ", statusID=" + statusID +
                ", bom='" + bom + '\'' +
                '}';
    }
}