package Model;

public enum BusType {
    PARTY_BUS("Party Bus"),
    SCHOOL_BUS("School Bus"),
    REGULAR_BUS("Regular Bus");
    private String value;
    private BusType(String type) {
        this.value = type;
    }

    @Override
    public String toString() {
        return value;
    }
}
