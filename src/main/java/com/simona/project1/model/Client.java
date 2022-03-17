package com.simona.project1.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity

public class Client {
    @Id
    private Integer id_client = 0;
    private String name;
    private String email;
    private String phone_number;

    public Client() {
    }

    public Client( String name, String email, String phone_number) {

        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
    }



    public Integer getId_client() {
        return id_client;
    }

    public void setId_client(Integer id_client) {
        this.id_client = id_client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

}
