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

    /**
     * Constructor
     * @param name
     * @param email
     * @param phone_number
     */
    public Client( String name, String email, String phone_number) {

        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
    }


    /**
     * return id
     * @return
     */
    public Integer getId_client() {
        return id_client;
    }

    /**
     * set id
     * @param id_client
     */
    public void setId_client(Integer id_client) {
        this.id_client = id_client;
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
     * get email
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * set email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get phone number
     * @return
     */
    public String getPhone_number() {
        return phone_number;
    }

    /**
     * set phone number
     * @param phone_number
     */
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

}
