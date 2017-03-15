package controller.order;

import dao.ClientDAOFactory;
import dao.OrderDAOFactory;
import dao.abstr.IClientDao;
import dao.abstr.IOrderDao;
import model.Client;
import model.Order;
import org.json.JSONArray;
import org.json.JSONObject;
import service.ClientService;
import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by v.apanovich on 2/24/2017.
 */

@WebServlet (urlPatterns = "/listOrders")
public class ListOrdersController extends HttpServlet {

    private OrderService orderService;

    @Override
    public void init() {
        IOrderDao dao = OrderDAOFactory.getOrderDAO(getServletContext().getInitParameter("dbConnType"));
        orderService = new OrderService(dao);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int clientId = getClientId(req);
        List<Order> orderList = orderService.listOrders(clientId);
        JSONArray orderJsonArray = new JSONArray();
        for (Order order : orderList) {
            orderJsonArray.put(new JSONObject(order));
        }

        resp.setContentType("application/json");
        resp.getWriter().write(orderJsonArray.toString());
    }

    private int getClientId(HttpServletRequest req) throws IOException {
        req.setCharacterEncoding("UTF-8");
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }

        return Integer.parseInt(buffer.toString());
    }
}
