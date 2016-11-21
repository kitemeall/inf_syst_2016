package Dao;

import Model.Car;
import Model.Worker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Workers {
    public static ArrayList<Worker> getWorkers(){

        String query = " Select id, name, speciality from dbo.Workers";
        Connection conn = null;
        ArrayList<Worker> workers = new ArrayList<Worker>();
        try{
            conn = SQLConnector.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){

                Worker worker = new Worker(rs.getInt("id"), rs.getString("name"),rs.getString("speciality"));
                workers.add(worker);
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
        return workers;
    }
}
