package com.ofs.training.java.pojo;

public class PojoServiceAddress {

    private long id;
    private String street;
    private String city;
    private int postal_code;

     public PojoServiceAddress(long i, String string, String string2, int j) {
         this.id = i;
         this.street = string;
         this.city = string2;
         this.postal_code = j;
 }
     public PojoServiceAddress(String string, String string2, int j) {
         this.street = string;
         this.city = string2;
         this.postal_code = j;
 }
     public PojoServiceAddress() {
     }
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
     @Override
     public String toString() {
         return "PojoServiceAddress [id=" + id + ", street=" + street + ", city=" + city + ", postal_code=" + postal_code + "]";
     }
 }
