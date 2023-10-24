package com.UtheC2.UtheC2.Entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name="Customers")
public class CustomersEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="customerID")
    private int customerID;

    public List<OrdersEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrdersEntity> orders) {
        this.orders = orders;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="customerID",referencedColumnName = "customerID")
    private List<OrdersEntity> orders = new ArrayList<>();

    @Column(name="forename")
    private String forename;
    @Column(name="surname")
    private String surname;
    @Column(name="address")
    private String address;
    @Column(name="dob")
    private Date dob;

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhn() {
        return phn;
    }

    public void setPhn(String phn) {
        this.phn = phn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="phone_number")
    private String phn;
    @Column(name="email")
    private String email;
}
