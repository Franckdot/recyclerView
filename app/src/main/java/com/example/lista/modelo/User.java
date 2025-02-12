package com.example.lista.modelo;

public class User {
    private int id;

    private String username;
    private String name;
    private String email;
    //private String address;

    /*public String getStreet() {
        return street;
    }

    private String street;*/
    private String phone;
    private String website;
    private String company;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getUserName() {
        return username;
    }
    public void setUserName(String username) {
        this.username = username;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }*/

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    /*public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }*/
}
