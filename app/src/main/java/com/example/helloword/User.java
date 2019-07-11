package com.example.helloword;

import java.io.Serializable;

public class User implements Serializable {
    String name , phoneNumber ,dateOfBirth , email , privince ;

    public User(String name, String phoneNumber, String dateOfBirth, String email, String privince) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.privince = privince;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrivince() {
        return privince;
    }

    public void setPrivince(String privince) {
        this.privince = privince;
    }
}
