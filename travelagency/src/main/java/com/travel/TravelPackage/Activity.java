package com.travel.TravelPackage;

/**
 * The class Activity
 */
public class Activity {
    private int activityId;
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private int destinationId;

    /**
     *
     * It is a constructor.
     *
     * @param activityId    the activity identifier.
     * @param name          the name.
     * @param desc          the desc.
     * @param cost          the cost.
     * @param capacity      the capacity.
     * @param destinationId the destination identifier.
     */
    public Activity(int activityId, String name, String desc, double cost, int capacity, int destinationId) {

        this.activityId = activityId;
        this.name = name;
        this.description = desc;
        this.cost = cost;
        this.capacity = capacity;
        this.destinationId = destinationId;
    }

    /**
     *
     * Gets the activity identifier
     *
     * @return the activity identifier
     */
    public int getActivityId() {

        return activityId;
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
     * Gets the cost
     *
     * @return the cost
     */
    public double getCost() {

        return cost;
    }

    /**
     *
     * Gets the description
     *
     * @return the description
     */
    public String getDescription() {

        return description;
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
     * Gets the destination identifier
     *
     * @return the destination identifier
     */
    public int getDestinationId() {

        return destinationId;
    }

    /**
     *
     * Sets the destination identifier
     *
     * @param destinationId the destination identifier.
     */
    public void setDestinationId(int destinationId) {

        if (this.destinationId != 0) {
            this.destinationId = destinationId;
        }
        return;
    }

    /**
     *
     * Reduce capacity
     *
     */
    public void reduceCapacity() {

        this.capacity = this.capacity - 1;
    }
}
