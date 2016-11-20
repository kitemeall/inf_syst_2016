package Servlets;

import Model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

@WebServlet("/cars")
public class Cars extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Car> cars = Dao.Cars.getCars();
        String json = new Gson().toJson(cars);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String modelId = req.getParameter("model_id");
        String number = req.getParameter("number");
        String vin = req.getParameter("vin");
        if(modelId == null || number == null || vin == null){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        else{
            int modelIntId = Integer.parseInt(modelId);
            Car car = new Car(modelIntId, number, vin);
            int newCarId = Dao.Cars.addCar(car);
            if(newCarId == -1){
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
           resp.getWriter().print(newCarId);
        }
    }
}
