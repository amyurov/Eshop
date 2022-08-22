package Shop;

import Shop.Printer.Printer;
import Shop.Printer.SortBy;
import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private Printer printer;

    // 3. single responsibility principle. Класс Menu отвечает только за правильный вывод возможных действий.
    // Реализация действий делегируется классу принтер.

    public Menu(Printer printer) {
        this.printer = printer;
    }


    public void assortment() {
        System.out.println("Добро пожаловать в магазин");
        System.out.println("Выберете действие:\n1.Просмотреть весь ассортимент\n2.Просмотреть доступный ассортимент");

        Integer input = Integer.parseInt(sc.nextLine());
        switch (input) {
            case 1:
                setSorted(false);
                break;
            case 2:
                setSorted(true);
                break;
        }
    }

    public void setSorted(boolean available) {
        System.out.println("Сортировка\n1.Тип товара\n2.Производитель\n3.Модель\n4.Цена\n5.Без сортировки");

        Integer input = Integer.parseInt(sc.nextLine());
        switch (input) {
            case 1:
                order(available, SortBy.NAME);
                break;
            case 2:
                order(available, SortBy.MANUFACTURER);
                break;
            case 3:
                order(available, SortBy.MODEL);
                break;
            case 4:
                order(available, SortBy.PRICE);
                break;
            case 5:
                printer.print(available);
                break;
        }
    }

    public void order(boolean available, SortBy sortBy) {
        System.out.println("Отобразить\n1.По возрастанию\n2.По убыванию");

        Integer input = Integer.parseInt(sc.nextLine());
        switch (input) {
            case 1:
                printer.print(available, sortBy);
                break;
            case 2:
                printer.print(available, sortBy, true);
                break;
        }
    }

}
