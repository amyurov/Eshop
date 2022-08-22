package Shop;

import java.util.HashSet;
import java.util.Set;

public class Storage {
    private static Storage instance = null;

    private Set<Product> products;

    private Storage() {
        products = new HashSet<>();
    }

    public static Storage get() {
        if (instance == null) instance = new Storage();
        return instance;
    }

    public Set<Product> getProductSet() {
        return products;
    }

    public void addToStorage(Product p) {
       if (!products.add(p)) System.out.println("Товар" + p + " Уже имеется на складе");;
    }

}
