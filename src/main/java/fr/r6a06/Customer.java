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

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        Enumeration rentals = _rentals.elements();

        String result = "Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();
            //determine amounts for each line
            thisAmount = amountForCurrentRental(each);
            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                    each.getDaysRented() > 1) frequentRenterPoints++;
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) +
                " frequent renter points";
        return result;
    }

    private static double amountForCurrentRental(Rental each) {
        double r = 0;
        switch (each.getMovie().getPriceCode()) { // <==
            case Movie.REGULAR:
                r += 2;
                if (each.getDaysRented() > 2)
                    r += (each.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                r += each.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                r += 1.5;
                if (each.getDaysRented() > 3)
                    r += (each.getDaysRented() - 3) * 1.5;
                break;
        }
        return r;
    }
}
