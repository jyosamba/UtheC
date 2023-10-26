package com.UtheC2.UtheC2.Controllers;

import com.UtheC2.UtheC2.Entities.UserEntity;
import com.UtheC2.UtheC2.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    AuthorRepo Repo;

    @Autowired
    BooksRepo RepoB;

    @Autowired
    CustomersRepo RepoC;

    @Autowired
    GenresRepo RepoG;

    @Autowired
    OrderDetailsRepo RepoOD;

    @Autowired
    OrdersRepo RepoO;

    @Autowired
    PaymentsRepo RepoPay;

    @Autowired
    PublishersRepo RepoP;

    @Autowired
    UserRepo RepoU;

    @GetMapping("/user")
    public String method(){ return null;}

}
