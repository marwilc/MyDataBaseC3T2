package com.marwilc.mydatabase;

import java.util.Date;

/**
 * Created by marwilc on 11/05/17.
 */

public class Contact {
    private String fullName;
    private String birthDate;
    private String phone;
    private String email;
    private String detail;

    public Contact(String fullName, String birthDate, String phone, String email, String detail) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
        this.detail = detail;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
