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


    public Product() {
    }

    public Product( Integer id, String name, String category, Integer stoc, double price) {
        this.id_product = id;
        this.name = name;
        this.stoc = stoc;
        this.price = price;
        this.category = category;
    }

    public Product( String name, String category, Integer stoc, double price) {

        this.name = name;
        this.stoc = stoc;
        this.price = price;
        this.category = category;
    }

    public Integer getId_product() {
        return id_product;
    }

    public void setId_product(Integer id) {
        this.id_product = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() { return category;  }

    public void setCategory(String category) { this.category = category;   }

    public Integer getStoc() {
        return stoc;
    }

    public void setStoc(Integer stoc) {
        this.stoc = stoc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
