package fr.r6a06;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;

    private Vector<Rental> _rentals = new Vector<Rental>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    private double getTotalAmount(Enumeration rentals) {
        double totalamount = 0;

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            totalamount += each.getCharge();
        }
        return totalamount;
    }

    public int getFrequentRentalPoints(Enumeration rentals) {
        int frequentrentalpoints = 0;

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            frequentrentalpoints++;
            frequentrentalpoints = getFrequentRenterPoints(each, frequentrentalpoints);
        }
        return frequentrentalpoints;
    }

    public String statement() {
        Enumeration rentals = _rentals.elements();

        String result = "Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalAmount(rentals)) + "\n";
        result += "You earned " + String.valueOf(getFrequentRentalPoints(rentals)) + " frequent renter points";
        return result;
    }

    private static int getFrequentRenterPoints(Rental each, int frequentRenterPoints) {
        // add bonus for a two day new release rental
        if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                each.getDaysRented() > 1) frequentRenterPoints++;
        return frequentRenterPoints;
    }
}
