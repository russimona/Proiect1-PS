package com.simona.project1.model.user;


public class Vizitator extends BasicUser {

    public Vizitator() {
        super();
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

