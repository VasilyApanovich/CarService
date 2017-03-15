package dao.abstr;

import model.Client;

import java.util.List;

/**
 * Created by v.apanovich on 2/24/2017.
 */
public interface IClientDao {
    public List<Client> listClients();
    public void addClient(Client client);
    public Client getClientById(int id);
    public boolean editClient(Client client);
    public boolean deleteClient(int id);
}
