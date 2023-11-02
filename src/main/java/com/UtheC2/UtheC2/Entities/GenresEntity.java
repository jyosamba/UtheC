package com.UtheC2.UtheC2.Entities;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Genres")
public class GenresEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="genreID")
    private int genreID;

    @Column(name="name")
    private String name;
    @Column(name="fiction")
    private boolean fiction;

    @OneToMany(mappedBy = "genre",cascade = CascadeType.ALL)
    private List<BooksEntity> bookList;
    public int getGenreID() {
        return genreID;
    }

    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFiction() {
        return fiction;
    }

    public void setFiction(boolean fiction) {
        this.fiction = fiction;
    }

}
