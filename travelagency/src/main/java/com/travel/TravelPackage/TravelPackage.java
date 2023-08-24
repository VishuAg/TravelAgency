package com.travel.TravelPackage;

import java.util.ArrayList;
import java.util.HashMap;

import com.travel.Passenger.Passenger;
import com.travel.Utils.PrintHelper;

/**
 * The class Travel package
 */
public class TravelPackage {
    String name;
    int capacity;
    HashMap<Integer, Destination> destination;
    ArrayList<Passenger> passengers;

    /**
     *
     * It is a constructor.
     *
     * @param name     the name.
     * @param capacity the capacity.
     */
    public TravelPackage(String name, int capacity) {

        this.name = name;
        this.capacity = capacity;
        destination = new HashMap<>();
        passengers = new ArrayList<>();
    }

    /**
     *
     * Gets the capacity
     *
     * @return the capacity
     */
    public int getCapacity() {

        return capacity;
    }

    /**
     *
     * Gets the all destination
     *
     * @return the all destination
     */
    public HashMap<Integer, Destination> getAllDestination() {

        return destination;
    }

    /**
     *
     * Gets the name
     *
     * @return the name
     */
    public String getName() {

        return name;
    }

    /**
     *
     * Sets the capacity
     *
     * @param capacity the capacity.
     */
    public void setCapacity(int capacity) {

        this.capacity = capacity;
    }

    /**
     *
     * Gets the passengers
     *
     * @return the passengers
     */
    public ArrayList<Passenger> getPassengers() {

        return passengers;
    }

    /**
     *
     * Add destination to package
     *
     * @param destinationId the destination identifier.
     * @param destination   the destination.
     */
    public void addDestinationToPackage(Integer destinationId, Destination destination) {

        this.destination.put(destinationId, destination);
    }

    /**
     *
     * Add passenger to package
     *
     * @param pass the pass.
     */
    public void addPassengerToPackage(Passenger pass) {

        this.passengers.add(pass);
    }

    /**
     *
     * Show destinations
     *
     */
    public void showDestinations() {

        HashMap<Integer, Destination> destinations = this.getAllDestination();
        PrintHelper.printDestinations(destinations);
    }

    /**
     *
     * Gets the destination by identifier
     *
     * @param destinationId the destination identifier.
     * @return the destination by identifier
     */
    public Destination getDestinationById(int destinationId) {

        return this.getAllDestination().get(destinationId);
    }

    /**
     *
     * Show package details
     *
     */
    public void showPackageDetails() {

        PrintHelper.printPackageDetails(this);
    }

    /**
     *
     * Reduce capacity
     *
     */
    public void reduceCapacity() {

        this.setCapacity(this.getCapacity() - 1);
    }
}
