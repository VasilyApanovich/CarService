package controller.client;

import dao.ClientDAOFactory;
import dao.abstr.IClientDao;
import model.Client;
import org.json.JSONArray;
import org.json.JSONObject;
import service.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by v.apanovich on 2/24/2017.
 */

@WebServlet (urlPatterns = "/listClients")
public class ListClientsController extends HttpServlet {

    private ClientService clientService;

    @Override
    public void init() {
        IClientDao dao = ClientDAOFactory.getClientDAO(getServletContext().getInitParameter("dbConnType"));
        clientService = new ClientService(dao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Client> clientList = clientService.listClients();
        JSONArray clientJsonArray = new JSONArray();
        for (Client client : clientList) {
            clientJsonArray.put(new JSONObject(client));
        }

        resp.setContentType("application/json");
        resp.getWriter().write(clientJsonArray.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
