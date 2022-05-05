package com.simona.project1.model.user;

public class UserFactory {

    public BasicUser createUser(UserTypeEnum userType, String nume, String email, String phone_number, String password){
        switch (userType) {
            case CLIENT:
                return new Client(nume,email, phone_number, password);
            case ADMIN:
                return new Admin(nume,email, phone_number, password);
            case VIZITATOR:
                return new Vizitator();
        }
        return null;
    }
}