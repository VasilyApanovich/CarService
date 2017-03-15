package dao;

import dao.abstr.IClientDao;
import dao.impl.hibernate.HibernateClientDaoImpl;
import dao.impl.jdbc.JDBCClientDaoImpl;

/**
 * Created by apano on 10.03.2017.
 */
public class ClientDAOFactory {
    public static IClientDao getClientDAO(String type) {
        switch (type) {
            case "jdbc":
                return new JDBCClientDaoImpl();
            case "hibernate":
                return new HibernateClientDaoImpl();
            default:
                throw new IllegalArgumentException();
        }
    }
}
