package Model;

/**
 * Created by Администратор on 20.11.2016.
 */
public class Service {
    private String name;
    private int price;
    private int id;

    public Service(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
