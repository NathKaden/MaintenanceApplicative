package fr.r6a06;

public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public double getCharge() {
        double r = 0;
        switch (this.getMovie().getPriceCode()) { // <==
            case Movie.REGULAR:
                r += 2;
                if (this.getDaysRented() > 2)
                    r += (this.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                r += this.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                r += 1.5;
                if (this.getDaysRented() > 3)
                    r += (this.getDaysRented() - 3) * 1.5;
                break;
        }
        return r;
    }
}
