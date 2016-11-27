package Dao;

import Model.Car;

import java.sql.*;
import java.util.ArrayList;

public class Cars {
    public static ArrayList<Car> getCars(){

        String query = "SELECT Cars.id as id, number, vin, name\n" +
                "FROM dbo.Cars\n" +
                "LEFT JOIN dbo.Models\n" +
                "ON Cars.model_id = Models.id;";
        Connection conn = null;
        ArrayList<Car> cars = new ArrayList<Car>();
        try{
            conn = SQLConnector.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){

                Car car = new Car(rs.getInt("id"),rs.getString("name"),rs.getString("number"),rs.getString("vin"));
                cars.add(car);
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
        return cars;
    }

    public static int addCar(Car car){
        String query = "insert into dbo.Cars (model_id, number, vin) VALUES (?, ?, ?)";
        Connection conn = null;
        int newCarId = -1;
        try{
            conn = SQLConnector.getConnection();
            PreparedStatement ps = conn.prepareStatement(query,  Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, car.getModelId());
            ps.setString(2, car.getNumber());
            ps.setString(3, car.getVin());
            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                   newCarId = generatedKeys.getInt(1);
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
        return newCarId;
    }

    public static void deleteCar(int carId){
        Connection conn = null;
        try
        {
            conn = SQLConnector.getConnection();
            PreparedStatement st = conn.prepareStatement("DELETE FROM dbo.Cars WHERE id = ?");
            st.setInt(1,carId);
            st.executeUpdate();
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
    }
}
