package com.simona.project1.model.user;


public class Admin extends BasicUser {

    public Admin(){
        super();

    }
    public Admin(String nume, String email, String phone_number, String password) {
        super(nume, email, phone_number, "ADMIN", password );
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

