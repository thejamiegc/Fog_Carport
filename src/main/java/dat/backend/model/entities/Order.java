package dat.backend.model.entities;

import java.sql.Timestamp;

public class Order {
    private int orderID;
    private int customerID;
    private Timestamp created;
    private int carportID;
    private double price;
    private int statusID;
    private Carport carport;
    private String statusname;
    private int bomID;
    private BillOfMaterials bom;
    private User user;

    public Order(int orderID, int customerID, Timestamp created, int carportID, double price, int statusID, Carport carport, String statusname) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.created = created;
        this.carportID = carportID;
        this.price = price;
        this.statusID = statusID;
        this.carport = carport;
        this.statusname = statusname;
    }

    public Order(int customerID, Timestamp created, int carportID, double price, int statusID) {
        this.customerID = customerID;
        this.created = created;
        this.carportID = carportID;
        this.price = price;
        this.statusID = statusID;
    }

    public Order(int customerID, int carportID, int statusID) {
        this.customerID = customerID;
        this.carportID = carportID;
        this.statusID = statusID;
    }

    public Order(int customerID, Timestamp created, int carportID, double price, int statusID, Carport carport, String statusname, BillOfMaterials bom) {
        this.customerID = customerID;
        this.created = created;
        this.carportID = carportID;
        this.price = price;
        this.statusID = statusID;
        this.carport = carport;
        this.statusname = statusname;
        this.bom = bom;
    }

    public Order(int orderID, int customerID, Timestamp created, int carportID, double price, int statusID, Carport carport, String statusname, int bomID, BillOfMaterials bom, User user) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.created = created;
        this.carportID = carportID;
        this.price = price;
        this.statusID = statusID;
        this.carport = carport;
        this.statusname = statusname;
        this.bomID = bomID;
        this.bom = bom;
        this.user = user;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public int getOrderID() {
        return orderID;
    }

    public Carport getCarport() {
        return carport;
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

    public String getStatusname() {
        return statusname;
    }

    public BillOfMaterials getBom() {
        return bom;
    }

    public int getBomID() {
        return bomID;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", customerID=" + customerID +
                ", created=" + created +
                ", carportID=" + carportID +
                ", price=" + price +
                ", statusID=" + statusID +
                ", carport=" + carport +
                ", statusname='" + statusname + '\'' +
                ", bom=" + bom +
                '}';
    }
}