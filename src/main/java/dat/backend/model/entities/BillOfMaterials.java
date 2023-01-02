package dat.backend.model.entities;

public class BillOfMaterials {
    // VARIABLES
    private int bomID;
    private int orderID;
    private int materialID;
    private String description;
    private int quantity;
    private double price;
    private Material material;

    // CONSTRUCTOR
    public BillOfMaterials() {
    }
    // CONSTRUCTOR
    public BillOfMaterials(int bomID, int orderID, int materialID, String description, int quantity, double price, Material material) {
        this.bomID = bomID;
        this.orderID = orderID;
        this.materialID = materialID;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.material = material;
    }
    // CONSTRUCTOR
    public BillOfMaterials(int bomID, int orderID, int materialID, String description, int quantity, double price) {
        this.bomID = bomID;
        this.orderID = orderID;
        this.materialID = materialID;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }
    // CONSTRUCTOR
    public BillOfMaterials(int orderID, int materialID, String description, int quantity, double price, Material material) {
        this.orderID = orderID;
        this.materialID = materialID;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.material = material;
    }
    // GETTERS
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

    @Override
    public String toString() {
        return "Materiale: " + material.getDescription() + "\n" +
                "Længde: " + material.getLength() + "\n" +
                "Antal: " + quantity + "\n" +
                "Enhed: " + material.getUnit() + "\n" +
                "Anvendelse: " + description + "\n" +
                "Pris: " + price;
    }
}