package Dao;

import Model.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Orders {
    public static ArrayList<Order> getOrders(){

        String query = "select Repair.id,Models.name as model_name , Cars.number, Clients.name as client_name, Repair.start_date  from Repair  left join Cars\n" +
                "on Repair.car_id = Cars.id\n" +
                "left join Clients\n" +
                "ON Repair.client_id = Clients.id\n" +
                "left join Models \n" +
                "on Cars.model_id = Models.id\n" +
                "where Repair.done = 0;";
        Connection conn = null;
        ArrayList<Order> orders = new ArrayList<Order>();
        try{
            conn = SQLConnector.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                Order order = new Order(rs.getInt("id"),
                        rs.getString("model_name"),
                        rs.getString("number"),
                        rs.getString("client_name"),
                        rs.getString("start_date") );
                orders.add(order);
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
        return orders;
    }
}
