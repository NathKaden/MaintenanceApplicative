package fr.r6a06;

import static fr.r6a06.Movie.*;

public abstract class Price {

    public Price(int price) {
        int _price = price;
    }

    public abstract int getPriceCode();

    public abstract double getCharge(int daysRented);

//    public abstract double getCharge(Rental rental) {
//        double result = 0.0;
//        switch (rental.getMovie().getPriceCode()) {
//            case REGULAR:
//                result += 2;
//                if (rental.getDaysRented() > 2)
//                    result += (rental.getDaysRented() - 2) * 1.5;
//                break;
//            case NEW_RELEASE:
//                result += rental.getDaysRented() * 3;
//                break;
//            case CHILDRENS:
//                result += 1.5;
//                if (rental.getDaysRented() > 3)
//                    result += (rental.getDaysRented() - 3) * 1.5;
//                break;
//        }
//        return result;
//    }
}
