package com.simona.project1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private Integer id_product;
    private String name;
    private double price;
    private String category;
    private Integer stoc;

    /**
     * constructor
     */
    public Product() {
    }

    /**
     * constructor
     * @param id
     * @param name
     * @param category
     * @param stoc
     * @param price
     */

    public Product( Integer id, String name, String category, Integer stoc, double price) {
        this.id_product = id;
        this.name = name;
        this.stoc = stoc;
        this.price = price;
        this.category = category;
    }

    /**
     * constructor
     * @param name
     * @param category
     * @param stoc
     * @param price
     */
    public Product( String name, String category, Integer stoc, double price) {

        this.name = name;
        this.stoc = stoc;
        this.price = price;
        this.category = category;
    }

    /**
     * get id
     * @return
     */
    public Integer getId_product() {
        return id_product;
    }

    /**
     * set id
     * @param id
     */
    public void setId_product(Integer id) {
        this.id_product = id;
    }

    /**
     * get name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * set name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get category
     * @return
     */
    public String getCategory() { return category;  }

    /**
     * set category
     * @param category
     */
    public void setCategory(String category) { this.category = category;   }

    /**
     * get stoc
     * @return
     */
    public Integer getStoc() {
        return stoc;
    }

    /**
     * set stoc
     * @param stoc
     */
    public void setStoc(Integer stoc) {
        this.stoc = stoc;
    }

    /**
     * get price
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * set price
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
