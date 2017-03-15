package dao.impl.jdbc;

import java.sql.*;

import model.Client;
import dao.abstr.IClientDao;
import database.ConnectionManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v.apanovich on 2/24/2017.
 */
public class JDBCClientDaoImpl implements IClientDao{

    private Connection connection;

    public JDBCClientDaoImpl() {
        connection = ConnectionManager.getConnection();
    }

    public List<Client> listClients() {
        List<Client> clientsList = new ArrayList<Client>();

        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM client";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int clientId = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String birthDate = resultSet.getString("birthDate");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");

                clientsList.add(new Client(clientId, firstName, lastName, birthDate, phone, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientsList;
    }

    public Client getClientById(int id) {
        Client client = null;
        try {
            String query = "SELECT * FROM client WHERE id = " + id + "";
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int clientId = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String birthDate = resultSet.getString("birthDate");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");

                client = new Client(clientId, firstName, lastName, birthDate, phone, email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return client;
    }

    public void addClient(Client client) {

        try {
            String query = "INSERT INTO client(firstName, lastName, birthDate, phone, email) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, client.getFirstName());
            statement.setString(2, client.getLastName());
            statement.setString(3, client.getBirthDate());
            statement.setString(4, client.getPhone());
            statement.setString(5, client.getEmail());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean editClient(Client client) {

        try {
            String query = "UPDATE client SET firstName = ?, lastName = ?, birthDate = ?, phone = ?, email = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, client.getFirstName());
            statement.setString(2, client.getLastName());
            statement.setString(3, client.getBirthDate());
            statement.setString(4, client.getPhone());
            statement.setString(5, client.getEmail());
            statement.setInt(6, client.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean deleteClient(int id) {
        try {
            String query = "DELETE FROM client WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
