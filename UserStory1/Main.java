package UserStory1;

public class Main {
    public static void main(String[] args) {
        FlightManager flightManager = new FlightManager();

        flightManager.addFlight(new Flight(1, "YUL", "YYZ", 1));
        flightManager.addFlight(new Flight(2, "YUL", "YYC", 1));
        flightManager.addFlight(new Flight(3, "YUL", "YVR", 1));
        flightManager.addFlight(new Flight(4, "YUL", "YYZ", 2));
        flightManager.addFlight(new Flight(5, "YUL", "YYC", 2));
        flightManager.addFlight(new Flight(6, "YUL", "YYR", 2));

        flightManager.showFlights();
    }

}
