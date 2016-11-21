package Servlets;

import Model.WorkInfo;
import Model.WorkItem;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/workDetails")
public class WorkDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = request.getParameter("order_data");
        WorkInfo workInfo = new Gson().fromJson(json, WorkInfo.class);
        int result =  Dao.WorkUnits.addWork(workInfo);
        if(result == -1){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int orderId = Integer.parseInt(request.getParameter("order_id"));
            ArrayList<WorkItem> workItems = Dao.WorkUnits.getWorkItems(orderId);
            String json = new Gson().toJson(workItems);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
        catch (Exception e){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }
}
