package dao.impl.hibernate;

import dao.abstr.IClientDao;
import model.Client;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by apano on 10.03.2017.
 */
public class HibernateClientDaoImpl implements IClientDao {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Client> listClients() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Client");
        List<Client> clients = query.list();
        session.close();
        return clients;
    }

    @Override
    public void addClient(Client client) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(client);
        transaction.commit();
        session.close();
    }

    @Override
    public Client getClientById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Client client = session.get(Client.class, id);
        session.close();
        return client;
    }

    @Override
    public boolean editClient(Client client) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(client);
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
    public boolean deleteClient(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            session.delete(client);
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
}
