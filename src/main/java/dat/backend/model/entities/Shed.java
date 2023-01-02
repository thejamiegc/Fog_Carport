package dat.backend.model.entities;

public class Shed {
    // VARIABLES
    private int shedID;
    private int shedLength;
    private int shedWidth;
    private int shedOrderID;

    // CONSTRUCTOR
    public Shed(int shedID, int shedLength, int shedWidth, int shedOrderID) {
        this.shedID = shedID;
        this.shedLength = shedLength;
        this.shedWidth = shedWidth;
        this.shedOrderID = shedOrderID;
    }

    // CONSTRUCTOR
    public Shed(int shedLength, int shedWidth) {
        this.shedLength = shedLength;
        this.shedWidth = shedWidth;
    }

    // GETTERS
    public int getShedLength() {
        return shedLength;
    }

    public int getShedWidth() {
        return shedWidth;
    }

    public int getShedID() {
        return shedID;
    }

    public int getShedOrderID() {
        return shedOrderID;
    }


    // SETTERS
    public void setShedID(int shedID) {
        this.shedID = shedID;
    }

    public void setShedLength(int shedLength) {
        this.shedLength = shedLength;
    }

    public void setShedWidth(int shedWidth) {
        this.shedWidth = shedWidth;
    }

    public void setShedOrderID(int shedOrderID) {
        this.shedOrderID = shedOrderID;
    }
}