package com.travel.Passenger;

/**
 * The class Standard passenger extends wallet passenger
 */
public class StandardPassenger extends WalletPassenger {
    private final double discountPercentage = 0.0;
    double balance = 100;

    /**
     *
     * Standard passenger
     *
     * @param name        the name.
     * @param passengerNo the passenger number.
     */
    public StandardPassenger(String name, String passengerNo) {

        super(name, passengerNo);
    }

    /**
     *
     * Gets the discount percentage
     *
     * @return the discount percentage
     */
    public double getDiscountPercentage() {

        return discountPercentage;
    }

}
