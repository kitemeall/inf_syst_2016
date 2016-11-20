package Model;

/**
 * Created by Администратор on 20.11.2016.
 */
public class Car {
    private String model;
    private String number;
    private String vin;
    private int modelId;

    public Car(String model, String number, String vin) {
        this.model = model;
        this.number = number;
        this.vin = vin;
    }

    public Car(int modelId, String number, String vin) {
        this.number = number;
        this.vin = vin;
        this.modelId = modelId;
    }

    public String getModel() {
        return model;
    }

    public String getNumber() {
        return number;
    }

    public String getVin() {
        return vin;
    }

    public int getModelId() {
        return modelId;
    }
}
