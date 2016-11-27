package Model;

/**
 * Created by Администратор on 27.11.2016.
 */
public class OrderDetails {
    private String client;
    private String phone;
    private String vin;
    private String model;
    private String number;

    public OrderDetails(String client, String phone, String vin, String model, String number) {
        this.client = client;
        this.phone = phone;
        this.vin = vin;
        this.model = model;
        this.number = number;
    }
}
