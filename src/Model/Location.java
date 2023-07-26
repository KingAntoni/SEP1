package Model;

public enum Location {
    COPENHAGEN("Copenhagen"),
    AARHUS("Aarhus"),
    HORSENS("Horsens"),
    AALBORG("Aalborg"),
    HERNING("Herning"),
    VIBY("Viby"),
    MIDDELFART("Middelfart");
    private String value;
    private Location(String type) {
        this.value = type;
    }

    @Override
    public String toString() {
        return value;
    }
}
