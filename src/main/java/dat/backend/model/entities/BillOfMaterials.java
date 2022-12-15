package dat.backend.model.entities;

import java.util.ArrayList;
import java.util.List;

public class BillOfMaterials {

    private int bomID;
    private int orderID;
    private int materialID;
    private String description;
    private int quantity;
    private double price;
    private Material material;

    public BillOfMaterials() {
    }

    public BillOfMaterials(int bomID, int orderID, int materialID, String description, int quantity, double price, Material material) {
        this.bomID = bomID;
        this.orderID = orderID;
        this.materialID = materialID;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.material = material;
    }

    public BillOfMaterials(int bomID, int orderID, int materialID, String description, int quantity, double price) {
        this.bomID = bomID;
        this.orderID = orderID;
        this.materialID = materialID;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public BillOfMaterials(int orderID, int materialID, String description, int quantity, double price, Material material) {
        this.orderID = orderID;
        this.materialID = materialID;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.material = material;
    }

    public int getBomID() {
        return bomID;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getMaterialID() {
        return materialID;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public Material getMaterial() {
        return material;
    }
}
