package com.simona.project1.model.user;

public class UserFactory {

    public BasicUser createUser(UserTypeEnum userType){
        switch (userType) {
            case CLIENT:

                return new Client();
            case ADMIN:
                return new Admin();
            case VIZITATOR:
                return new Vizitator();
        }
        return null;
    }


}