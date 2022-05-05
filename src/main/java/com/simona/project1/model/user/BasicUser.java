package com.simona.project1.model.user;

public abstract class BasicUser {
    public String nume = null;
    public String email = null;
    public String phone_number = null;
    public String type = null;
    public String password = null;

    public BasicUser(){

    }

    public BasicUser (String nume, String email, String phone_number, String type, String password){
        this.nume = nume;
        this.email = email;
        this.phone_number = phone_number;
        this.type = type;
        this.password = password;
    }



    @Override
    public int hashCode() {
        return super.hashCode();
    }



    @Override
    public boolean equals(Object obj) {
        if( obj instanceof BasicUser){
            if(((BasicUser) obj).nume == this.nume && ((BasicUser) obj).email == this.email){
                return true;
            }
        }
        return false;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
