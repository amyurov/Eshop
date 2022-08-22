package Shop.Printer;

//7. Interface Segregation - Данный интерфейс имеет только один метод, хоть и перегруженный.
// Вместо того чтобы дописывать сюда новое поведение для принтера, лучше будет их вынести в отдельный интерфейс, чем делать один большой

public interface Printer {

    void print();
    void print(boolean available);
    void print(boolean available, SortBy sortBy);
    void print(boolean available, SortBy sortBy, boolean reverseOrder);
}
