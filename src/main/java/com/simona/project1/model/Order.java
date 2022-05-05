package com.simona.project1.model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order {
    @Id
    private Integer id_order;
    private Double total_price;
    private Integer order_number;
    private Integer id_product;
    private String email_client;

    public Order() {
    }

    /**
     * consturctor
     * @param total_price
     * @param order_number
     * @param id_product
     * @param email_client
     */
    public Order( Double total_price, Integer order_number, Integer id_product, String email_client) {

        this.total_price = total_price;
        this.order_number = order_number;
        this.id_product = id_product;
        this.email_client = email_client;
    }

    /**
     * constructor
     * @param id
     * @param total_price
     * @param order_number
     * @param id_product
     * @param email_client
     */
    public Order( Integer id, Double total_price, Integer order_number, Integer id_product, String email_client) {
        this.id_order = id;
        this.total_price = total_price;
        this.order_number = order_number;
        this.id_product = id_product;
        this.email_client = email_client;
    }


    /**
     * get id
     * @return
     */
    public Integer getId_order() {
        return id_order;
    }

    /**
     * set id
     * @param id_order
     */
    public void setId_order(Integer id_order) {
        this.id_order = id_order;
    }

    /**
     * get price
     * @return
     */
    public Double getTotal_price() {
        return total_price;
    }

    /**
     * set price
     * @param total_price
     */
    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    /**
     * get order number
     * @return
     */
    public Integer getOrder_number() {
        return order_number;
    }

    /**
     * set order number
     * @param order_number
     */
    public void setOrder_number(Integer order_number) {
        this.order_number = order_number;
    }

    /**
     * get id prod
     * @return
     */
    public Integer getId_product() {
        return id_product;
    }

    /**
     * set id prod
     * @param id_product
     */
    public void setId_product(Integer id_product) {
        this.id_product = id_product;
    }

    public String getEmail_client() {
        return email_client;
    }

    public void setEmail_client(String email_client) {
        this.email_client = email_client;
    }
}
