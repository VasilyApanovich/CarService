package dao;

import dao.abstr.IOrderDao;
import dao.impl.hibernate.HibernateOrderDaoImpl;
import dao.impl.jdbc.JDBCOrderDaoImpl;

/**
 * Created by apano on 10.03.2017.
 */
public class OrderDAOFactory {
    public static IOrderDao getOrderDAO(String type) {
        switch (type) {
            case "jdbc":
                return new JDBCOrderDaoImpl();
            case "hibernate":
                return new HibernateOrderDaoImpl();
            default:
                throw new IllegalArgumentException();
        }
    }
}
