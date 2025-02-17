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

    public double getTotalCharge() {
        double totalAmount = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            totalAmount += each._movie.getCharge(each);
        }
        return totalAmount;
    }

    public int getTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            frequentRenterPoints += each._movie.getRenterPoints(each);
        }
        return frequentRenterPoints;
    }

    public String statement() {
        Enumeration rentals = _rentals.elements();
        String result = "Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each._movie.getCharge(each)) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) +
                " frequent renter points";
        return result;
    }
}