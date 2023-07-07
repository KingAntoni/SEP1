package Model;

public class Bus {
    public enum BusType {
        PartyBus,
        SchoolBus,
        LUXURY
    }

    private BusType type;
    private int numberOfSeats;

    public Bus(BusType type, int numberOfSeats) {
        this.type = type;
        this.numberOfSeats = numberOfSeats;
    }

    public BusType getType() {
        return type;
    }

    public void setType(BusType type) {
        this.type = type;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}

