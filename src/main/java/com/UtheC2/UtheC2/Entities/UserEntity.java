package com.UtheC2.UtheC2.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="Users")
public class UserEntity {

    @Id
    @Column(name="UserName")
    private String userName;

    @Column(name="pwd")
    private String pwd;

    @OneToOne
    @JoinColumn(name="customerID")
    private CustomersEntity customers;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public CustomersEntity getCustomers() {
        return customers;
    }

    public void setCustomers(CustomersEntity customers) {
        this.customers = customers;
    }

}
