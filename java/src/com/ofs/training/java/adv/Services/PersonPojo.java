package com.ofs.training.java.adv.Services;

    import java.util.Date;

    public class PersonPojo {

        long id;
        String name;
        String email;
        Date birth_date;
        Date created_date;
        long address_id;
        AddressPojo address;

        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
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
        public Date getBirth_date() {
            return birth_date;
        }
        public void setBirth_date(Date birth_date) {
            this.birth_date = birth_date;
        }
        public Date getCreated_date() {
            return created_date;
        }
        public void setCreated_date(Date created_date) {
            this.created_date = created_date;
        }
        public long getAddress_id() {
            return address_id;
        }
        public void setAddress_id(long address_id) {
            this.address_id = address_id;
        }
        public AddressPojo getAddress() {
            return address;
        }
        public void setAddress(AddressPojo address) {
            this.address = address;
        }

    }


