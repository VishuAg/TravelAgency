package com.travel.Utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * The class Validation helper
 */
public class ValidationHelper {

    /**
     *
     * Validate operation
     *
     * @param operation        the operation.
     * @param allowedOperation the allowed operation.
     * @return boolean
     */
    public static boolean validateOperation(int operation, HashSet<Integer> allowedOperation) {

        if (!allowedOperation.contains(operation)) {
            System.out.println("Enter valid operation");
            return false;
        }
        return true;
    }

    /**
     *
     * Validate operation at main menu
     *
     * @param operation the operation.
     * @return boolean
     */
    public static boolean validateOperationAtMainMenu(int operation) {

        List<Integer> list = Arrays.asList(1, 2, 6, 7, 9);
        HashSet<Integer> mainMenuOperations = new HashSet<>(list);
        return validateOperation(operation, mainMenuOperations);
    }

    /**
     *
     * Validate operation for unregistered passenger
     *
     * @param operation the operation.
     * @return boolean
     */
    public static boolean validateOperationForUnregisteredPassenger(int operation) {
        List<Integer> list = Arrays.asList(1, 4, 8, 9);
        HashSet<Integer> unregisteredPassengerOperations = new HashSet<>(list);
        return validateOperation(operation, unregisteredPassengerOperations);
    }

    /**
     *
     * Validate operation for registered passenger
     *
     * @param operation the operation.
     * @return boolean
     */
    public static boolean validateOperationForRegisteredPassenger(int operation) {
        List<Integer> list = Arrays.asList(1, 3, 5, 8, 9);
        HashSet<Integer> validateOperationForRegisteredPassenger = new HashSet<>(list);
        return validateOperation(operation, validateOperationForRegisteredPassenger);
    }
}
