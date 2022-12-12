package dat.backend.model.entities;

public class Item {
    double totalPrice;
    double pricePerMeter;
    int length;
    int quantity;
    String type;

    public Item(double pricePerMeter, int length, int quantity, String type) {
        this.pricePerMeter = pricePerMeter;
        this.length = length;
        this.quantity = quantity;
        this.type = type;

        totalPrice = length * (pricePerMeter / 100) * quantity;
    }
}
