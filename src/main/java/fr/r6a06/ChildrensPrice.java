package fr.r6a06;

public class ChildrensPrice extends Price {

    private Price _price;

    public ChildrensPrice(int price) {
        super(price);
    }

    @Override
    public int getPriceCode() {
        return this._price.getPriceCode();
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3){
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }
}
