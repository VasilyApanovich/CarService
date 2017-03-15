package dao.impl.hibernate;

import dao.abstr.IOrderDao;
import model.Client;
import model.Order;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by apano on 10.03.2017.
 */
public class HibernateOrderDaoImpl implements IOrderDao {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Order> listOrders(int clientId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Order where clientId = :clientId");
        query.setParameter("clientId", clientId);
        List<Order> orders = query.list();
        session.close();
        return orders;
    }

    @Override
    public void addOrder(Order order) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(order);
        transaction.commit();
        session.close();
    }

    @Override
    public Order getOrderById(int orderId) {
        return null;
    }

    @Override
    public boolean editOrder(Order order) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(order);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }

        return true;
    }

    @Override
    public boolean deleteOrder(int orderId) {
        return false;
    }
}
