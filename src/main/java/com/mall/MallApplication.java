package com.mall;

import static java.util.Arrays.asList;
import static java.util.Arrays.copyOfRange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.mall.calc.PriceCalculator;

/**
 * The Class MallApplication.
 */
public class MallApplication {

    /**
     * Gets the inventory details.
     *
     * @param scanner stdin reader
     * @return the inventory details
     */
    public static Map<String, List<String>> getInventoryDetails(Scanner scanner) {
        Map<String, List<String>> inventoryMap = new HashMap<>();
        int numOfRecords = readNextIntegerFromInput(scanner);

        for (int i = 0 ; i < numOfRecords ; i++) {
            String[] inventory = scanner.nextLine().split("\\s*,\\s*");
            inventoryMap.put(inventory[0], asList(copyOfRange(inventory, 1, inventory.length)));
        }
        return inventoryMap;
    }

    /**
     * Gets the customer options.
     *
     * @param scanner stdin reader
     * @return the customer options
     */
    public static List<String[]> getCustomerInputs(Scanner scanner) {
        List<String[]> customerInputs = new ArrayList<>();
        int numOfRecords = readNextIntegerFromInput(scanner);

        for (int i = 0 ; i < numOfRecords ; i++) {
            String[] options = scanner.nextLine().split("\\s*,\\s*");
            customerInputs.add(options);
        }
        scanner.close();
        return customerInputs;
    }

    /**
     * Read next integer from input.
     *
     * @param scanner the scanner
     * @return the int
     */
    private static int readNextIntegerFromInput(Scanner scanner) {
        int numOfRecords = 0;
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (!nextLine.isEmpty()) {
                numOfRecords = Integer.valueOf(nextLine);
                break;
            }
        }
        return numOfRecords;
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        PriceCalculator priceCalculator = new PriceCalculator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease enter inventory details:");
        Map<String, List<String>> inventoryMap = getInventoryDetails(scanner);
        System.out.println("\nPlease enter customer options:");
        List<String[]> customerInputs = getCustomerInputs(scanner);
        scanner.close();
        System.out.println("\nOutput:");
        for (String[] options : customerInputs) {
            double totalPrice = 0;
            for (String option : options) {
                List<String> inventoryDetails = inventoryMap.get(option);
                if (inventoryDetails != null) {
                    totalPrice += priceCalculator.calculateEffectivePrice(inventoryDetails.get(0), inventoryDetails.get(1),
                            inventoryDetails.get(2));
                }
            }
            System.out.println(totalPrice);
        }
    }

}
