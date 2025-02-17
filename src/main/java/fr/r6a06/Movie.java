package fr.r6a06;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private Price _price;

    public Movie(String title, int priceCode) {
        _title = title;
        this.setPriceCode(priceCode);
    }

    public String getTitle(){
        return _title;
    };

    public Price getPriceCode() {
        return _price;
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode){
            case REGULAR:
                this._price = new RegularPrice(this._price.getPriceCode());
                break;
            case NEW_RELEASE:
                this._price = new NewReleasePrice(this._price.getPriceCode());
                break;
            case CHILDRENS:
                this._price = new ChildrensPrice(this._price.getPriceCode());
        }
    }

    public double getCharge(Rental rental) {
        return this._price.getPriceCode();
    }

    public int getRenterPoints(Rental rental) {
        if ((this._price.getPriceCode() == NEW_RELEASE) &&
                rental.getDaysRented() > 1)
            return 2;
        else
            return 1;
    }
}