package dao.impl.jdbc;

import dao.abstr.IOrderDao;
import model.Order;

import java.util.List;

/**
 * Created by apano on 10.03.2017.
 */
public class JDBCOrderDaoImpl implements IOrderDao {
    @Override
    public List<Order> listOrders(int clientId) {
        return null;
    }

    @Override
    public void addOrder(Order order) {

    }

    @Override
    public Order getOrderById(int orderId) {
        return null;
    }

    @Override
    public boolean editOrder(Order order) {
        return false;
    }

    @Override
    public boolean deleteOrder(int orderId) {
        return false;
    }
}
