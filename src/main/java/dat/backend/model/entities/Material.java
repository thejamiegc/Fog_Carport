package dat.backend.model.entities;

public class Material {
    String description;
    int length;
    int quantity;
    String unit;
    String itemDescription;
    double pricePerMeter;
    double totalPrice;
    String type;
    int typeID;


    public Material(String description, int length, int quantity, String unit, String itemDescription, double pricePerMeter, String type, int typeID) {
        this.description = description;
        this.length = length;
        this.quantity = quantity;
        this.unit = unit;
        this.itemDescription = itemDescription;
        this.pricePerMeter = pricePerMeter;
        this.type = type;
        this.typeID = typeID;

        this.totalPrice = length * (pricePerMeter / 100) * quantity;

    }

    public String getDescription() {
        return description;
    }

    public int getLength() {
        return length;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public double getPricePerMeter() {
        return pricePerMeter;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getType() {
        return type;
    }

    public int getTypeID() {
        return typeID;
    }
}
