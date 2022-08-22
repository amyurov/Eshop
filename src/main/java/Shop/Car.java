package Shop;

public class Car extends Product{

    private int year;

    public Car(String name, String manufacterer, String model, int price, int count, int year) {
        super(name, manufacterer, model, price, count);
        this.year = year;
    }
}
