package controller.client;

import dao.ClientDAOFactory;
import dao.abstr.IClientDao;
import service.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by v.apanovich on 2/24/2017.
 */
@WebServlet(urlPatterns = "/deleteClient")
public class DeleteClientController extends HttpServlet {

    private ClientService clientService;

    @Override
    public void init() {
        IClientDao dao = ClientDAOFactory.getClientDAO(getServletContext().getInitParameter("dbConnType"));
        clientService = new ClientService(dao);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }

        clientService.deleteClient(Integer.parseInt(buffer.toString()));
    }
}
