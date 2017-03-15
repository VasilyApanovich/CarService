package dao.abstr;

import model.Client;
import model.Order;

import java.util.List;

/**
 * Created by apano on 10.03.2017.
 */
public interface IOrderDao {
    public List<Order> listOrders(int clientId);
    public void addOrder(Order order);
    public Order getOrderById(int orderId);
    public boolean editOrder(Order order);
    public boolean deleteOrder(int orderId);
}
