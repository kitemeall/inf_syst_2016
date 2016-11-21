package Model;

/**
 * Created by Администратор on 21.11.2016.
 */
public class WorkItem {
    private String serviceName;
    private String workerName;
    private String workerSpec;
    private int price;

    public WorkItem(String serviceName, String workerName, String workerSpec, int price) {
        this.serviceName = serviceName;
        this.workerName = workerName;
        this.workerSpec = workerSpec;
        this.price = price;
    }
}
