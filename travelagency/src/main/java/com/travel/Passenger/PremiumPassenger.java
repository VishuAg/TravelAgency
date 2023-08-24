package com.travel.Passenger;

import com.travel.Passenger.PassengerUtil.ActivityDetails;
import com.travel.TravelPackage.Activity;
import com.travel.Utils.PrintHelper;

/**
 * The class Premium passenger extends passenger
 */
public class PremiumPassenger extends Passenger {
    private final int discountPercentage = 100;
    private final double balance = Double.MAX_VALUE;

    /**
     *
     * Premium passenger
     *
     * @param name        the name.
     * @param passengerNo the passenger number.
     */
    public PremiumPassenger(String name, String passengerNo) {

        super(name, passengerNo);

    }

    /**
     *
     * Book activity
     *
     * @param a the a.
     * @return boolean
     */
    public boolean bookActivity(Activity a) {

        if (addActivity(a)) {
            this.activities.put(a.getActivityId(), new ActivityDetails(0, a));
            return true;
        }
        return false;
    }

    /**
     *
     * View my details
     *
     */
    public void viewMyDetails() {

        printPassengerDetails();
    }

    /**
     *
     * Gets the balance
     *
     * @return the balance
     */
    public double getBalance() {

        return balance;
    }

    /**
     *
     * Gets the discount percentage
     *
     * @return the discount percentage
     */
    public int getDiscountPercentage() {

        return discountPercentage;
    }

    /**
     *
     * Print passenger details
     *
     */
    public void printPassengerDetails() {

        System.out.println("\t\tPassenger Name: " + this.getName() +
                " Passenger no : " + this.getPassengerNo());

        PrintHelper.printActivitiesEnrolledByPassenger(this.getActivities());
    }
}
