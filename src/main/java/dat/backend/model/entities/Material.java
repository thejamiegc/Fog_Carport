package dat.backend.model.entities;

public class Material {
    private int materialID;
    private String description;
    private int length;
    private String unit;
    private double pricePerUnit;
    private int type;
    private String typename;


    public Material(int materialID, String description, int length, String unit, double pricePerUnit, int type) {
        this.materialID = materialID;
        this.description = description;
        this.length = length;
        this.unit = unit;
        this.pricePerUnit = pricePerUnit;
        this.type = type;
    }


    public Material(String description, int length, String unit, double pricePerUnit, int type) {
        this.description = description;
        this.length = length;
        this.unit = unit;
        this.pricePerUnit = pricePerUnit;
        this.type = type;
    }

    public Material(int materialID, String description, int length, String unit, double pricePerUnit, int type, String typename) {
        this.materialID = materialID;
        this.description = description;
        this.length = length;
        this.unit = unit;
        this.pricePerUnit = pricePerUnit;
        this.type = type;
        this.typename = typename;
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

    public String getTypename() {
        return typename;
    }
}
