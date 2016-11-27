package Model;

/**
 * Created by Администратор on 20.11.2016.
 */
public class Client {
    private int id;
    private String name;
    private String phone;

    public Client(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
    public Client( String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
