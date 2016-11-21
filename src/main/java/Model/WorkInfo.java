package Model;

import java.util.ArrayList;


public class WorkInfo {
    private int orderId;
    private ArrayList<WorkUnit> workUnits;

    public int getOrderId() {
        return orderId;
    }

    public ArrayList<WorkUnit> getWorkUnits() {
        return workUnits;
    }

    public class WorkUnit{
        public int serviceId;
        public int workerId;

    }
}

