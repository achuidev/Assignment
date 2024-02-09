package UserStory2;

import java.util.ArrayList;
import java.util.List;

public class Flight {
    private int flightNumber;
    private String departureCity;
    private String arrivalCity;
    private List<Order> orders;

    public Flight(int flightNumber, String departureCity, String arrivalCity) {
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.orders = new ArrayList<>();
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

}
