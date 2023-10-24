package com.UtheC2.UtheC2.Entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="payments")
public class PaymentsEntity {
    @Column(name="date_of_order")
    private Date date;
    @Column(name="amount")
    private double amount;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="paymentID")
    private int paymentID;

   //@OneToOne(cascade = CascadeType.ALL)
    //private OrdersEntity orders;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }


}
