package com.UtheC2.UtheC2.Entities;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Books")
public class BooksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bookID")
    private int bookID;


    @Column(name="hardcover")
    private boolean hardcover;
    @Column(name="title")
    private String title;
    @Column(name="issue")
    private Integer issue=1;
    @Column(name="isbn")
    private String isbn;

    public List<AuthorEntity> getAuthor() {
        return author;
    }

    public void setAuthor(List<AuthorEntity> author) {
        this.author = author;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="authorID",referencedColumnName = "bookID")
    private List<AuthorEntity> author;

    @OneToOne
    //@JoinColumn(name="publisherID")
    private PublishersEntity publisher;

    @OneToOne
    @JoinColumn(name="genreID")
    private GenresEntity genre;

    private int quantity;

    private float price;

    public GenresEntity getGenre() {
        return genre;
    }

    public void setGenre(GenresEntity genre) {
        this.genre = genre;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isHardcover() {
        return hardcover;
    }

    public void setHardcover(boolean hardcover) {
        this.hardcover = hardcover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIssue() {
        return issue;
    }

    public void setIssue(Integer issue) {
        this.issue = issue;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }


    public PublishersEntity getPublisher() {
        return publisher;
    }

    public void setPublisher(PublishersEntity publisherID) {
        this.publisher = publisherID;
    }


}

