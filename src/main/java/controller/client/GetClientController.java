package controller.client;

import dao.ClientDAOFactory;
import dao.abstr.IClientDao;
import model.Client;
import org.json.JSONObject;
import service.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by v.apanovich on 2/24/2017.
 */
@WebServlet(urlPatterns = "/getClient")
public class GetClientController extends HttpServlet {

    private ClientService clientService;

    @Override
    public void init() {
        IClientDao dao = ClientDAOFactory.getClientDAO(getServletContext().getInitParameter("dbConnType"));
        clientService = new ClientService(dao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int clientId = Integer.parseInt(req.getParameter("id").toString());
        Client client = clientService.getClientById(clientId);

        resp.setContentType("application/json");
        resp.getWriter().write(new JSONObject(client).toString());
    }
}
