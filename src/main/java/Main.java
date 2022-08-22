
import Shop.*;
import Shop.Printer.ConsolePrinter;
import Shop.Printer.Printer;

public class Main {
    public static void main(String[] args) {
        initialization();
        //6. dependency inversion principle Реализация принтера зависит от абстракции. Тут можно было бы выбрать не
        // консольный принтер, а, например, принтер реализующий печать в файл.
        Printer printer = new ConsolePrinter();
        Menu menu = new Menu(printer);

        menu.assortment();


    }

    public static void initialization() {

        Product p1 = new Product("MobilePhone", "Samsung", "x-11", 25000, 20);
        Product p2 = new Product("Montor", "AOC", "RZ2205", 17500, 10);
        Product p3 = new Product("Watch", "Xiaomi", "Band3", 5500, 0);

        //5. Liskov substitution principle Любые объекты типа Product, присутствующие в программе, могут заменяться объектами типа Car
        Product c1 = new Car("Car", "Audi", "Q5", 55500, 5, 2020);

    }
}
