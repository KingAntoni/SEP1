package Model;

public class Bus {
    public enum BusType {
        PartyBus,
        SchoolBus,
        RegularBus
    }

    private BusType type;
    private int numberOfSeats;
    private String id;

    public Bus(BusType type, int numberOfSeats, String id) {
        this.type = type;
        this.numberOfSeats = numberOfSeats;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

