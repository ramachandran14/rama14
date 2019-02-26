package model;

import java.sql.Date;

public class PojoServicePerson {

    long id;
    String first_name;
    String last_name;
    String email;
    long address_id;
    String birth_date;
    Date created_date;
    PojoServiceAddress address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(long address_id) {
        this.address_id = address_id;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public PojoServiceAddress getAddress() {
        return address;
    }

    public void setAddress(PojoServiceAddress address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PojoServicePerson [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email="
                + email + ", address_id=" + address_id + ", birth_date=" + birth_date + ", created_date=" + created_date
                + ", address=" + address + ", getId()=" + getId() + ", getFirst_name()=" + getFirst_name()
                + ", getLast_name()=" + getLast_name() + ", getEmail()=" + getEmail() + ", getAddress_id()="
                + getAddress_id() + ", getBirth_date()=" + getBirth_date() + ", getCreated_date()=" + getCreated_date()
                + ", getAddress()=" + getAddress() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + ", toString()=" + super.toString() + "]";
    }
}
