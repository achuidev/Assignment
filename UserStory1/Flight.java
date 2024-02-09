package UserStory1;

import java.util.ArrayList;
import java.util.List;

class Flight {
    private int flightNumber;
    private String departureCity;
    private String arivalCity;
    private int day;

    public Flight(int flightNumber, String departureCity, String arrivalCity, int day) {
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.arivalCity = arrivalCity;
        this.day = day;
    }

    public void showDetails() {
        System.err.println("Flight: " + flightNumber + ", departure: " + departureCity + ", arrival: " + arivalCity
                + ", day:" + day);
    }
}

class FlightManager {
    private List<Flight> flights;

    public FlightManager() {
        flights = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void showFlights() {
        for (Flight flight : flights) {
            flight.showDetails();
        }
    }
}