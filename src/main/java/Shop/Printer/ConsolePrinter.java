package Shop.Printer;

import Shop.Product;
import Shop.Storage;
import java.util.*;

public class ConsolePrinter implements Printer {
    private static Storage storage = Storage.get();
    //1. Избегаем магические числа, указав дефолтные значения в полях класса
    private final int ColumnWidth = 15;
    private final int ColumnCount = 4;

    //2. DRY - Выражаем аргумент форматирования в параметр, храня нужные нам значения в enum-е
    private String formatSetup(TextAlignment side) {
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        for (int i = 0; i < (ColumnCount); i++) {
            sb.append(side == TextAlignment.LEFT ? "%-" : "%");
            sb.append(ColumnWidth);
            sb.append("s|");
        }
        sb.append("%n");
        return sb.toString();
    }
    //2. DRY - Выражаем отрисовку хедера и тела таблицы в отдельные методы т.к. будем использовать ее несколько раз.
    // Если нужно поменять шапку или тело мы будем менять только этот метод
    private void printHeader(TextAlignment alignment) {
        System.out.printf(formatSetup(alignment), "Товар", "Производитель", "Модель", "Цена");
    }

    private void printColumn(TextAlignment alignment, Product p) {
        System.out.printf(formatSetup(alignment), p.getName(), p.getManufacterer(), p.getModel(), p.getPrice());
    }

    public ConsolePrinter() {
    }

    public void print() {
        List<Product> list = new ArrayList<>(storage.getProductSet());

        printHeader(TextAlignment.LEFT);
        for (Product product : list) {
            printColumn(TextAlignment.RIGHT, product);
        }
    }

    public void print(boolean available) {
        List<Product> list = new ArrayList<>(storage.getProductSet());

        printHeader(TextAlignment.LEFT);
        for (Product product : list) {
            if (available) {
                if (product.getCount() == 0) {
                    printColumn(TextAlignment.RIGHT, product);
                }
            } else {
                printColumn(TextAlignment.RIGHT, product);
            }
        }
    }

    //2. DRY - ниже идут перегруженные реализации метода print, где возможные вариации вынесены в параметры метода
    public void print(boolean available, SortBy sortBy) {
        List<Product> list = new ArrayList<>(storage.getProductSet());

        if (sortBy == SortBy.NAME) {
            list.sort(Comparator.comparing(Product::getName));
        } else if (sortBy == SortBy.MANUFACTURER) {
            list.sort(Comparator.comparing(Product::getManufacterer));
        } else if (sortBy == SortBy.MODEL) {
            list.sort(Comparator.comparing(Product::getModel));
        } else if (sortBy == SortBy.PRICE) {
            list.sort(Comparator.comparing(Product::getPrice));
        }

        printHeader(TextAlignment.LEFT);
        for (Product product : list) {
            if (available) {
                if (product.getCount() == 0) {
                    printColumn(TextAlignment.RIGHT, product);
                }
            } else {
                printColumn(TextAlignment.RIGHT, product);
            }
        }
    }


    public void print(boolean available, SortBy sortBy, boolean reverseOrder) {
        List<Product> list = new ArrayList<>(storage.getProductSet());

        if (sortBy == SortBy.NAME) {
            list.sort(Comparator.comparing(Product::getName));
        } else if (sortBy == SortBy.MANUFACTURER) {
            list.sort(Comparator.comparing(Product::getManufacterer));
        } else if (sortBy == SortBy.MODEL) {
            list.sort(Comparator.comparing(Product::getModel));
        } else if (sortBy == SortBy.PRICE) {
            list.sort(Comparator.comparing(Product::getPrice));
        }

        if (reverseOrder) {
            Collections.reverse(list);
        }

        printHeader(TextAlignment.LEFT);
        for (Product product : list) {
            if (available) {
                if (product.getCount() == 0) {
                    printColumn(TextAlignment.RIGHT, product);
                }
            } else {
                printColumn(TextAlignment.RIGHT, product);
            }
        }
    }
}
