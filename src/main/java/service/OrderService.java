package service;

import dao.abstr.IOrderDao;
import model.Order;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by apano on 10.03.2017.
 */
public class OrderService {
    private IOrderDao orderDao;

    public OrderService(IOrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public List<Order> listOrders(int clientId) {
        return orderDao.listOrders(clientId);
    }

    public void addOrder(String serializedRequest) {
        Order order = deserializeOrder(serializedRequest);
        int clientId = deserializeClientId(serializedRequest);
        order.setClientId(clientId);
        orderDao.addOrder(order);
    }

    public Order getOrderById(int id) {
        return orderDao.getOrderById(id);
    }

    public boolean editOrder(String serializedOrder) {
        return orderDao.editOrder(deserializeOrder1(serializedOrder));
    }

    public boolean deleteOrder(int id) {
        return orderDao.deleteOrder(id);
    }

    private int deserializeClientId(String serializedRequest) {
        JSONObject request = new JSONObject(serializedRequest);
        int clientId = request.getInt("clientId");
        return clientId;
    }

    private Order deserializeOrder(String serializedOrder) {
        JSONObject request = new JSONObject(serializedOrder);
        JSONObject order = request.getJSONObject("order");
        String description = order.getString("description");
        String status = order.getString("status");
        int price = order.getInt("price");
        return new Order(description, status, price);
    }

    private Order deserializeOrder1(String serializedOrder) {
        JSONObject order = new JSONObject(serializedOrder);
        String description = order.getString("description");
        String status = order.getString("status");
        int price = order.getInt("price");
        int id = order.getInt("id");
        int clientId = order.getInt("clientId");
        return new Order(id, description, status, price, clientId);
    }
}
