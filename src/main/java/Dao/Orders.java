package Dao;

import Model.Client;
import Model.Order;
import Model.OrderDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public static int addOrder(int carId, int clientId){
        String query = "insert into dbo.Repair (car_id, client_id, start_date, done) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        int newOrderId = -1;
        try{
            conn = SQLConnector.getConnection();
            PreparedStatement ps = conn.prepareStatement(query,  Statement.RETURN_GENERATED_KEYS);
            java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
            ps.setInt(1, carId);
            ps.setInt(2, clientId);
            ps.setTimestamp(3, timestamp);
            ps.setBoolean(4, false);
            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                newOrderId = generatedKeys.getInt(1);
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
        return newOrderId;
    }

    public static void deleteOrder(int orderId){
        Connection conn = null;
        try
        {
            conn = SQLConnector.getConnection();
            PreparedStatement st = conn.prepareStatement("DELETE FROM dbo.Repair WHERE id = ?");
            st.setInt(1,orderId);
            st.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static OrderDetails getOrderDetails(int id){

        String query = "{call orderDetails (?)}";
        Connection conn = null;
      OrderDetails orderDetails= null;
        try{
            conn = SQLConnector.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                orderDetails = new OrderDetails(
                        rs.getString("client_name"),
                        rs.getString("phone"),
                        rs.getString("vin"),
                        rs.getString("model_name"),
                        rs.getString("number"));
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
        return orderDetails;
    }

    public static void endOrder(int orderId){
        Connection conn = null;
        try
        {
            conn = SQLConnector.getConnection();
            PreparedStatement st = conn.prepareStatement("update dbo.Repair\n" +
                    "set done = 1\n" +
                    "where Repair.id = ?");
            st.setInt(1,orderId);
            st.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


}
