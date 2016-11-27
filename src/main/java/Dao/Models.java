package Dao;

import Model.Model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Models {
    public static ArrayList<Model> getModels(){

        String query = "select id, name from dbo.Models;";
        Connection conn = null;
        ArrayList<Model> models = new ArrayList<Model>();
        try{
            conn = SQLConnector.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                Model model = new Model( rs.getInt("id"),rs.getString("name") );
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
