package com.ikats.passwordsaver.listviewhelpers;

import java.io.Serializable;

public class Password implements Serializable {

    public String Description;
    public String Password;

    public Password(String description, String password) {
        Description = description;
        Password = password;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
