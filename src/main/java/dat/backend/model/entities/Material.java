package dat.backend.model.entities;

public class Material {
    private int materialID;
    private String description;
    private int length;
    private String unit;
    private double pricePerUnit;
    private int type;
    private double totalPrice;

    private BillOfMaterials bom;

    public Material(int materialID, String description, int length, String unit, double pricePerUnit, int type) {
        this.materialID = materialID;
        this.description = description;
        this.length = length;
        this.unit = unit;
        this.pricePerUnit = pricePerUnit;
        this.type = type;
    }

    public Material(int materialID, String description, int length, String unit, double pricePerUnit, int type, BillOfMaterials bom) {
        this.materialID = materialID;
        this.description = description;
        this.length = length;
        this.unit = unit;
        this.pricePerUnit = pricePerUnit;
        this.type = type;
        this.bom = bom;
    }

    public Material(String description, int length, String unit, double pricePerUnit, int type) {
        this.description = description;
        this.length = length;
        this.unit = unit;
        this.pricePerUnit = pricePerUnit;
        this.type = type;
    }

    public double getTotalPrice() {
        totalPrice = length * (pricePerUnit/100) * bom.getQuantity();
        return totalPrice;
    }

    public int getMaterialID() {
        return materialID;
    }

    public String getDescription() {
        return description;
    }

    public int getLength() {
        return length;
    }

    public String getUnit() {
        return unit;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public int getType() {
        return type;
    }
}
