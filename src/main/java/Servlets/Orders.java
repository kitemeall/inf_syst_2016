package Servlets;

import Model.Client;
import Model.Order;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/orders")
public class Orders extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int carId = Integer.parseInt(req.getParameter("car_id"));
            int clientId = Integer.parseInt(req.getParameter("client_id"));
            int orderId = Dao.Orders.addOrder(carId, clientId);
            if(orderId == -1){
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }else {
                resp.getWriter().print(orderId);
            }
        }
        catch (Exception e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Order> orders = Dao.Orders.getOrders();
        String json = new Gson().toJson(orders);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
