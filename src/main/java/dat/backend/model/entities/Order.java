package dat.backend.model.entities;

import java.sql.Timestamp;

public class Order {
    int orderID;
    int employeeID;
    int customerID;
    Timestamp created;
    double price;
    int statusID;
    String bom;

    public Order(int orderID, int employeeID, int customerID, Timestamp created, double price, int statusID, String bom) {
        this.orderID = orderID;
        this.employeeID = employeeID;
        this.customerID = customerID;
        this.created = created;
        this.price = price;
        this.statusID = statusID;
        this.bom = bom;
    }

    public Order(int employeeID, int customerID, Timestamp created, double price, int statusID, String bom) {
        this.employeeID = employeeID;
        this.customerID = customerID;
        this.created = created;
        this.price = price;
        this.statusID = statusID;
        this.bom = bom;
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

    public double getPrice() {
        return price;
    }

    public int getStatusID() {
        return statusID;
    }

    public String getBom() {
        return bom;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", employeeID=" + employeeID +
                ", customerID=" + customerID +
                ", created=" + created +
                ", price=" + price +
                ", statusID=" + statusID +
                ", bom='" + bom + '\'' +
                '}';
    }
}
