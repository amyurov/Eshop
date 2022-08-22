package Shop;

import java.util.Objects;

public class Product {
    private static final Storage productStorage = Storage.get();

    private String name;
    private String manufacterer;
    private String model;
    private int price;
    private int count;

    public Product(String name, String manufacterer, String model, int price, int count) {
        this.name = name;
        this.manufacterer = manufacterer;
        this.model = model;
        this.price = price;
        this.count = count;
        productStorage.addToStorage(this);
    }

    public String getName() {
        return name;
    }

    public String getManufacterer() {
        return manufacterer;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(manufacterer, product.manufacterer) && Objects.equals(model, product.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, manufacterer, model);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", getName(), getManufacterer(), getModel());
    }


}



