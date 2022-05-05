package com.simona.project1.model.user;


public class Client extends BasicUser {

    public Client() {
        super();
    }

    public Client(String nume, String email, String phone_number, String password) {
        super(nume, email, phone_number, "CLIENT", password);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Admin;
    }
}

