package com.ofs.training.java.adv.Services;

public class AddressPojo {

    long id;
    String street;
    String city;
    int postal_code;
    AddressPojo addr;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public int getPostal_code() {
        return postal_code;
    }
    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }
    public AddressPojo getAddr() {
        return addr;
    }
    public void setAddr(AddressPojo addr) {
        this.addr = addr;
    }
}

