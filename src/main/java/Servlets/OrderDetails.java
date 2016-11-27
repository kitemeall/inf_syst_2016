package Servlets;

import Model.Order;
import Model.WorkItem;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Администратор on 27.11.2016.
 */
@WebServlet("/orderDetails")
public class OrderDetails extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int orderId = Integer.parseInt(request.getParameter("id"));
            Model.OrderDetails orderDetails = Dao.Orders.getOrderDetails(orderId);
            String json = new Gson().toJson(orderDetails);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
        catch (Exception e){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }
}
