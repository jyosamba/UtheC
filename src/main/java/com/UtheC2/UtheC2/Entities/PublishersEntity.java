package com.UtheC2.UtheC2.Entities;


import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name="Publishers")
public class PublishersEntity {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="publisherID")
    private int publisherId;
    @Column(name="company_name")
    private String companyName;
    @Column(name="copyright")
    private Boolean copyright;

//    @OneToOne(mappedBy = "publisher",cascade = CascadeType.ALL)
//    private BooksEntity bookList;

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Boolean getCopyright() {
        return copyright;
    }

    public void setCopyright(Boolean copyright) {
        this.copyright = copyright;
    }

}
