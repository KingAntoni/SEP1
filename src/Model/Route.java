package Model;

public class Route {
    private Location arrivalLocation;
    private Location departureLocation;

    public Route(Location arrivalLocation, Location departureLocation) {
        this.arrivalLocation = arrivalLocation;
        this.departureLocation = departureLocation;
    }


    public Location getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(Location arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public Location getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(Location departureLocation) {
        this.departureLocation = departureLocation;
    }


    @Override
    public String toString() {
        return
                "from=" + arrivalLocation +
                " to=" + departureLocation;
    }
}
