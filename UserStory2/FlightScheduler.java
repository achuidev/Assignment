package UserStory2;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.*;

public class FlightScheduler {
    public static void main(String[] args) {
        FlightScheduler scheduler = new FlightScheduler();
        List<Flight> flights = scheduler.generateFlights();
        Map<String, String> orders = scheduler
                .loadOrdersFromJson("UserStory2/orders.json");
        scheduler.scheduleOrders(flights, orders);
        scheduler.displayFlightItineraries(flights, orders);

    }

    private List<Flight> generateFlights() {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight(1, "YUL", "YYZ"));
        flights.add(new Flight(2, "YUL", "YYC"));
        flights.add(new Flight(3, "YUL", "YVR"));
        flights.add(new Flight(4, "YUL", "YYZ"));
        flights.add(new Flight(5, "YUL", "YYC"));
        flights.add(new Flight(6, "YUL", "YVR"));
        return flights;
    }

    private Map<String, String> loadOrdersFromJson(String fileName) {
        Map<String, String> orderData = new HashMap<>();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(fileName)) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            for (Object key : jsonObject.keySet()) {
                String orderId = (String) key;
                JSONObject orderDetails = (JSONObject) jsonObject.get(orderId);
                String destination = (String) orderDetails.get("destination");
                orderData.put(orderId, destination);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return orderData;
    }

    private void scheduleOrders(List<Flight> flights, Map<String, String> orders) {
        for (Flight flight : flights) {
            for (Iterator<Map.Entry<String, String>> iterator = orders.entrySet().iterator(); iterator.hasNext();) {
                Map.Entry<String, String> entry = iterator.next();
                String orderId = entry.getKey();
                String destination = entry.getValue();
                if (destination.equals(flight.getArrivalCity()) && flight.getOrders().size() < 20) {
                    flight.addOrder(new Order(orderId, destination));
                    iterator.remove();
                }
            }
        }
    }

    private void displayFlightItineraries(List<Flight> flights, Map<String, String> orders) {
        for (Flight flight : flights) {
            for (Order order : flight.getOrders()) {
                System.out.println("order: " + order.getOrderId() + ", flightNumber: " + flight.getFlightNumber() +
                        ", departure: " + flight.getDepartureCity() + ", arrival: " + flight.getArrivalCity());
            }
        }

        for (Map.Entry<String, String> entry : orders.entrySet()) {
            System.out.println("order: " + entry.getKey() + ", flightNumber: not scheduled");
        }
    }

}
