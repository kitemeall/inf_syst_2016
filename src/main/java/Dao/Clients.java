package Dao;

import Model.Car;
import Model.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Clients {
    public static ArrayList<Client> getClients(){

        String query = "SELECT name, phone from dbo.clients";
        Connection conn = null;
        ArrayList<Client> clients = new ArrayList<Client>();
        try{
            conn = SQLConnector.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){

                Client client = new Client(rs.getString("name"),rs.getString("phone"));
                clients.add(client);
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
        return clients;
    }

    public static int addClient(Client client){
        String query = "insert into dbo.Clients (name, phone) VALUES (?, ?)";
        Connection conn = null;
        int newClientId = -1;
        try{
            conn = SQLConnector.getConnection();
            PreparedStatement ps = conn.prepareStatement(query,  Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, client.getName());
            ps.setString(2, client.getPhone());
            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                newClientId = generatedKeys.getInt(1);
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
        return newClientId;
    }


    public static void deleteClient(int clientId){
        Connection conn = null;
        try
        {
            conn = SQLConnector.getConnection();
            PreparedStatement st = conn.prepareStatement("DELETE FROM dbo.Clients WHERE id = ?");
            st.setInt(1,clientId);
            st.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
