package com.UtheC2.UtheC2.Entities;
import jakarta.persistence.*;

@Entity
@Table(name="OrderDetails")
public class OrderDetailsEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderDetailsID;
    @ManyToOne
    @JoinColumn(name="orderID")
    private OrdersEntity orderID;

    @ManyToOne
    @JoinColumn(name="bookID")
    private BooksEntity bookID; //Change FK in table
    @Column(name="quantity")
    private int quantity;
    //price per book
    @Column(name="price_per_book")
    private float ppb;

    public OrdersEntity getOrderID() {
        return orderID;
    }

    public void setOrderID(OrdersEntity orderID) {
        this.orderID = orderID;
    }

    public BooksEntity getBookID() {
        return bookID;
    }

    public void setBookID(BooksEntity bookID) {
        this.bookID = bookID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPpb() {
        return ppb;
    }

    public void setPpb(float ppb) {
        this.ppb = ppb;
    }

    public int getOrderDetailsID() {
        return orderDetailsID;
    }

    public void setOrderDetailsID(int orderDetailsID) {
        this.orderDetailsID = orderDetailsID;
    }

}
