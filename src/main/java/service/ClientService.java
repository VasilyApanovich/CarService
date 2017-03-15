package service;

import dao.abstr.IClientDao;
import model.Client;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by v.apanovich on 2/24/2017.
 */
public class ClientService {

    private IClientDao clientDao;

    public ClientService(IClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public List<Client> listClients() {
        return clientDao.listClients();
    }

    public void addClient(String serializedClient) {
        clientDao.addClient(deserializeClient(serializedClient));
    }

    public Client getClientById(int id) {
        return clientDao.getClientById(id);
    }

    public boolean editClient(String serializedClient) {
        return clientDao.editClient(deserializeClient1(serializedClient));
    }

    public boolean deleteClient(int id) {
        return clientDao.deleteClient(id);
    }

    private Client deserializeClient(String serializedClient) {
        JSONObject client = new JSONObject(serializedClient);
        String firstName = client.getString("firstName");
        String lastName = client.getString("lastName");
        String birthDate = client.getString("birthDate");
        String phone = client.getString("phone");
        String email = client.getString("email");
        return new Client(firstName, lastName, birthDate, phone, email);
    }

    private Client deserializeClient1(String serializedClient) {
        JSONObject client = new JSONObject(serializedClient);
        String firstName = client.getString("firstName");
        String lastName = client.getString("lastName");
        String birthDate = client.getString("birthDate");
        String phone = client.getString("phone");
        String email = client.getString("email");
        int id = client.getInt("id");
        return new Client(id, firstName, lastName, birthDate, phone, email);
    }
}
