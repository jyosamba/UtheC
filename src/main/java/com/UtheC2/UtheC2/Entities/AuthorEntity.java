package com.UtheC2.UtheC2.Entities;

import jakarta.persistence.*;

import java.awt.print.Book;
import java.util.List;

@Entity
@Table(name = "authors")
public class AuthorEntity {
    @Column(name="name")
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="authorID")
    private int authorID;
    @Column(name="dead")
    public boolean dead;
    @Column(name="alias")
    private String alias;

//    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
//    private List<BooksEntity> booksList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public boolean getDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }


}
