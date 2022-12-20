package dat.backend.model.entities;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public class Order {
    private int orderID;
    private int customerID;
    private Timestamp created;
    private int carportID;
    private double price;
    private int statusID;

    private Carport carport;
    private String statusname;
    private Map<Integer,BillOfMaterials> billOfMaterialsList;
    private User user;
    private Shed shed;

    // Used in OrderMapper to show orders (myorders and allrequestsfromcustomers jsp )
    public Order(int orderID, int customerID, Timestamp created, int carportID, double price, int statusID, Carport carport, String statusname, Shed shed) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.created = created;
        this.carportID = carportID;
        this.price = price;
        this.statusID = statusID;
        this.carport = carport;
        this.statusname = statusname;
        this.shed = shed;
    }


    // Used in BuildCarport servlet
    public Order(User user, Carport carport, int statusID) {
        this.user = user;
        this.carport = carport;
        this.statusID = statusID;
    }


    public Order(int orderID, int customerID, Timestamp created, int carportID, double price, int statusID, Carport carport, String statusname, Map<Integer,BillOfMaterials> billOfMaterialsList, User user,Shed shed) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.created = created;
        this.carportID = carportID;
        this.price = price;
        this.statusID = statusID;
        this.carport = carport;
        this.statusname = statusname;
        this.billOfMaterialsList = billOfMaterialsList;
        this.user = user;
        this.shed = shed;
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

    public Shed getShed() {
        return shed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatusID() {
        return statusID;
    }

    public String getStatusname() {
        return statusname;
    }

    public User getUser() {
        return user;
    }

    public Map<Integer,BillOfMaterials> getBillOfMaterialsList() {
        return billOfMaterialsList;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
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
                '}';
    }

}