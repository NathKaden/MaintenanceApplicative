package fr.r6a06;

public class NewReleasePrice extends Price {

    private Price _price;

    public NewReleasePrice(int price) {
        super(price);
    }

    @Override
    public int getPriceCode() {
        return this._price.getPriceCode();
    }

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }
}
