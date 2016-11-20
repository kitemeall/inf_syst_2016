package Model;

/**
 * Created by Администратор on 20.11.2016.
 */
public class Order {
    private int id;
    private String model;
    private String number;
    private String clientName;
    private String startDate;

    public Order(int id, String model, String number, String clientName, String startDate) {
        this.id = id;
        this.model = model;
        this.number = number;
        this.clientName = clientName;
        this.startDate = startDate;
    }
}
