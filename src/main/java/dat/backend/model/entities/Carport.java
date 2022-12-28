package dat.backend.model.entities;

public class Carport {
    private int carportID;
    private int length;
    private int width;
    private String rooftype;
    private int orderID;

    //measurements are in cm and not meters
    public Carport(int carportID, int length, int width, String rooftype, int orderID) {
        this.carportID = carportID;
        this.length = length;
        this.width = width;
        this.rooftype = rooftype;
        this.orderID = orderID;
    }

    public Carport(int length, int width, String rooftype) {
        this.length = length;
        this.width = width;
        this.rooftype = rooftype;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getCarportSquareMeter() {
        return (length / 100) * (width / 100);
    }

    public int getCarportID() {
        return carportID;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public String getRooftype() {
        return rooftype;
    }

    public void setCarportID(int carportID) {
        this.carportID = carportID;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setRooftype(String rooftype) {
        this.rooftype = rooftype;
    }
}