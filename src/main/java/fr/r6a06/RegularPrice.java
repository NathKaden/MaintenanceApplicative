package fr.r6a06;

public class RegularPrice extends Price {

    private Price _price;

    public RegularPrice(int price) {
        super(price);
    }

    @Override
    public int getPriceCode() {
        return this._price.getPriceCode();
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2){
                    result += (daysRented - 2) * 1.5;
        }
        return result;
    }
}
