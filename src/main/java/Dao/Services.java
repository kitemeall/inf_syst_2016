package Dao;

import Model.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Services {
    public static ArrayList<Service> getServices(){

        String query = "select id, name , price from dbo.Services;";
        Connection conn = null;
        ArrayList<Service> services = new ArrayList<Service>();
        try{
            conn = SQLConnector.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){

                Service service = new Service(rs.getInt("id"),rs.getString("name"),rs.getInt("price"));
                services.add(service);
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
        return services;
    }
}
