package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by apano on 10.03.2017.
 */

@Entity
@Table (name = "order1")
public class Order {

    @Id
    private int id;
    private String description;
    private String status;
    private int price;
    private int clientId;

    public Order(String description, String status, int price) {
        this.description = description;
        this.status = status;
        this.price = price;
    }

    public Order(int id, String description, String status, int price) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.price = price;
    }

    public Order(int id, String description, String status, int price, int clientId) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.price = price;
        this.clientId = clientId;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
