package Model;

public class Location {
    private String arrivalLocation;
    private String departureLocation;

    public Location(String arrivalLocation, String departureLocation) {
        this.arrivalLocation = arrivalLocation;
        this.departureLocation = departureLocation;
    }


    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }


    @Override
    public String toString() {
        return "Location{" +
                "arrivalLocation='" + arrivalLocation + '\'' +
                ", departureLocation='" + departureLocation;
    }
}
