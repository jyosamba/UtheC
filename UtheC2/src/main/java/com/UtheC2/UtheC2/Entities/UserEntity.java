package com.UtheC2.UtheC2.Entities;

import javax.persistence.*;

@Entity
@Table(name="Users")
public class UserEntity {
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Id
    int userID;

    @Column(name="UserName")
    private String UserName;

    @Column(name="pwd")
    private String pwd;

    //@OneToOne
    //@JoinColumn(name="customerID")
    //private CustomersEntity customers;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

//    public CustomersEntity getCustomers() {
//        return customers;
//    }
//
//    public void setCustomers(CustomersEntity customers) {
//        this.customers = customers;
//    }

}
