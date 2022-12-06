package dat.backend.model.entities;

public class Carport {

    private int carportID;
    private int length;
    private int width;
    private String rooftype;
    private boolean shed;

    //measurements are in cm and not meters


    public Carport(int carportID, int length, int width, String rooftype, boolean shed) {
        this.carportID = carportID;
        this.length = length;
        this.width = width;
        this.rooftype = rooftype;
        this.shed = shed;
    }


    //getters
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

    public boolean isShed() {
        return shed;
    }

    //setters
    public void setLength(int length) {
        this.length = length;
    }

    public void setCarportID(int carportID) {
        this.carportID = carportID;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setRooftype(String rooftype) {
        this.rooftype = rooftype;
    }

    public void setShed(boolean shed) {
        this.shed = shed;
    }

    @Override
    public String toString() {
        return "Carport{" +
                "carportID=" + carportID +
                ", length=" + length +
                ", width=" + width +
                ", rooftype='" + rooftype + '\'' +
                ", shed=" + shed +
                '}';
    }
}
