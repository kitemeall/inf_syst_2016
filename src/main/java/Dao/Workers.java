package Dao;

import Model.Car;
import Model.Worker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Workers {
    public static ArrayList<Worker> getWorkers(){

        String query = " Select name, phone from dbo.Clients";
        Connection conn = null;
        ArrayList<Worker> workers = new ArrayList<Worker>();
        try{
            conn = SQLConnector.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){

                Worker worker = new Worker(rs.getString("name"),rs.getString("phone"));
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
