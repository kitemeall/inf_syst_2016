package Dao;

import Model.Car;
import Model.Order;
import Model.WorkInfo;
import Model.WorkItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class WorkUnits {
    public static int addWork(WorkInfo workInfo){
        String query = "insert into dbo.workUnit (repair_id, worker_id, service_id,  done) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        int newWorkUnitId = -1;
        try{
            conn = SQLConnector.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(query,  Statement.RETURN_GENERATED_KEYS);
            for (WorkInfo.WorkUnit unit :workInfo.getWorkUnits()) {
                ps.setInt(1, workInfo.getOrderId());
                ps.setInt(2, unit.workerId);
                ps.setInt(3, unit.serviceId);
                ps.setBoolean(4, false);
                ps.executeUpdate();
            }
            conn.commit();


            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                newWorkUnitId = generatedKeys.getInt(1);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return newWorkUnitId;
    }

    public static ArrayList<WorkItem> getWorkItems( int repairId){

        String query = "{call getWorkUnits(?)}";
        Connection conn = null;
        ArrayList<WorkItem> workItems = new ArrayList<WorkItem>();
        try{
            conn = SQLConnector.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, repairId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                WorkItem workItem = new WorkItem(
                        rs.getString("service"),
                        rs.getString("worker_name"),
                        rs.getString("speciality"),
                        rs.getInt("price")
                );
                workItems.add(workItem);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return workItems;
    }
}
