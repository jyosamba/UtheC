package com.UtheC2.UtheC2.Controllers;

import com.UtheC2.UtheC2.Entities.CustomersEntity;
import com.UtheC2.UtheC2.Entities.PublishersEntity;
import com.UtheC2.UtheC2.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PublisherController {
    @Autowired
    AuthorRepo Repo;

    @Autowired
    PublishersRepo RepoP;

    @Autowired
    CustomersRepo RepoC;

    @Autowired
    GenresRepo RepoG;

    @Autowired
    BooksRepo RepoB;

    @Autowired
    PaymentsRepo RepoPay;

    @Autowired
    OrdersRepo RepoO;

    @Autowired
    OrderDetailsRepo RepoOD;

    @GetMapping("/allPublishers")
    public List<PublishersEntity> Publishers() {
        return RepoP.findAll();
    }
}
