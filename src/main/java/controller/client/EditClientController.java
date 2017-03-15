package controller.client;

import dao.ClientDAOFactory;
import dao.abstr.IClientDao;
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
@WebServlet(urlPatterns = "/editClient")
public class EditClientController extends HttpServlet {

    private ClientService clientService;

    @Override
    public void init() {
        IClientDao dao = ClientDAOFactory.getClientDAO(getServletContext().getInitParameter("dbConnType"));
        clientService = new ClientService(dao);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        byte[] buffer = new byte[500];
        req.getInputStream().readLine(buffer, 0, 500);
        String reqText = new String(buffer);
        clientService.editClient(reqText);
    }
}
