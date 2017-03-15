package controller.order;

import dao.ClientDAOFactory;
import dao.OrderDAOFactory;
import dao.abstr.IClientDao;
import dao.abstr.IOrderDao;
import service.ClientService;
import service.OrderService;

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
@WebServlet(urlPatterns = "/editOrder")
public class EditOrderController extends HttpServlet {

    private OrderService orderService;

    @Override
    public void init() {
        IOrderDao dao = OrderDAOFactory.getOrderDAO(getServletContext().getInitParameter("dbConnType"));
        orderService = new OrderService(dao);
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

        orderService.editOrder(buffer.toString());
    }
}
