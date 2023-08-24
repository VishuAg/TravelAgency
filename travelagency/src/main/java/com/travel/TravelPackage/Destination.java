package com.travel.TravelPackage;

import java.util.HashMap;
import com.travel.Utils.PrintHelper;

/**
 * The class Destination
 */
public class Destination {
    int destinationId;
    String name;
    HashMap<Integer, Activity> activities;

    /**
     *
     * It is a constructor.
     *
     * @param destinationId the destination identifier.
     * @param name          the name.
     */
    public Destination(int destinationId, String name) {

        this.name = name;
        this.destinationId = destinationId;
        this.activities = new HashMap<>();
    }

    /**
     *
     * Gets the activities
     *
     * @return the activities
     */
    public HashMap<Integer, Activity> getActivities() {

        return activities;
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
     * Gets the name
     *
     * @return the name
     */
    public String getName() {

        return name;
    }

    /**
     *
     * Add activities
     *
     * @param activityId the activity identifier.
     * @param ac         the ac.
     */
    public void addActivities(int activityId, Activity ac) {

        this.activities.put(activityId, ac);
    }

    /**
     *
     * Show activites
     *
     */
    public void showActivites() {

        PrintHelper.printActivities(activities);
        return;
    }

    /**
     *
     * Gets the activity by identifier
     *
     * @param activityId the activity identifier.
     * @return the activity by identifier
     */
    public Activity getActivityById(int activityId) {

        return this.activities.get(activityId);
    }
}
