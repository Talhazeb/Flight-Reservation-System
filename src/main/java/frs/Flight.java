package frs;

public class Flight {
    String departure_location;
    String connecting_flight;
    String destination_location;
    String plane_no;
    String date;

    public void setDeparture_location(String departure_location) {
        this.departure_location = departure_location;
    }

    public String getDeparture_location() {
        return departure_location;
    }

    public void setConnecting_flight(String connecting_flight) {
        this.connecting_flight = connecting_flight;
    }

    public String getConnecting_flight() {
        return connecting_flight;
    }

    public void setDestination_location(String destination_location) {
        this.destination_location = destination_location;
    }

    public String getDestination_location() {
        return destination_location;
    }

    public void setPlane_no(String plane_no) {
        this.plane_no = plane_no;
    }

    public String getPlane_no() {
        return plane_no;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

}
