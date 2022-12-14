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

    public BillOfMaterials() {
    }

    public BillOfMaterials(int bomID, int orderID, int materialID, String description, int quantity, double price, List<Material> materialsList) {
        this.bomID = bomID;
        this.orderID = orderID;
        this.materialID = materialID;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.materialsList = materialsList;
    }

    public BillOfMaterials(int bomID, int orderID, int materialID, String description, int quantity, double price) {
        this.bomID = bomID;
        this.orderID = orderID;
        this.materialID = materialID;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    private List<Material> materialsList = new ArrayList<>();

    public void addMaterialToList(Material material){
        materialsList.add(material);
    }

    public List<Material> getMaterialsList() {
        return materialsList;
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
}
