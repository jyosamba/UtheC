package com.UtheC2.UtheC2.Entities;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Date;

@Entity
@Table(name="Orders")
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="orderID")
    private int orderID;

//    @ManyToOne
//    @JoinColumn(name="customerID")
//    private CustomersEntity customers;

    @Column(name="order_date")
    private Date orderDate;

    @OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name="paymentID")
    private PaymentsEntity payment;
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

//    public CustomersEntity getCustomers() {
//        return customers;
//    }
//
//    public void setCustomers(CustomersEntity customers) {
//        this.customers = customers;
//    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }



    public PaymentsEntity getPayment() {
        return payment;
    }

    public void setPayment(PaymentsEntity payment) {
        this.payment = payment;
    }



}
