package Dao;

import Model.Car;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Models {
    public static ArrayList<String> getModels(){

        String query = "select name from dbo.Models;";
        Connection conn = null;
        ArrayList<String> models = new ArrayList<String>();
        try{
            conn = SQLConnector.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                String model = rs.getString("name");
                models.add(model);
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
        return models;
    }
}
