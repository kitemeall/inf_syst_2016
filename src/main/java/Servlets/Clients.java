package Servlets;

import Model.Car;
import Model.Client;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/clients")
public class Clients extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Client> clients = Dao.Clients.getClients();
        String json = new Gson().toJson(clients);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        if(name == null || phone == null ){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        else{
            Client client = new Client(name, phone);
            int newClientId = Dao.Clients.addClient(client);
            if(newClientId == -1){
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
            resp.getWriter().print(newClientId);
        }
    }

}
