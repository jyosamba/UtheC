package com.UtheC2.UtheC2.Controllers;

import com.UtheC2.UtheC2.Entities.*;
import com.UtheC2.UtheC2.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

@RestController
public class AuthorController {

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

    @GetMapping("/abc")
    public String Message() {
        return "Hello My Friends";
    }

//    @GetMapping("/save")
//    public String CreateAuthor() {
//        AuthorEntity auth = new AuthorEntity();
//        PublishersEntity publishers = new PublishersEntity();
//        CustomersEntity customer = new CustomersEntity();
//        GenresEntity genre = new GenresEntity();
//        BooksEntity book = new BooksEntity();
//        PaymentsEntity pay = new PaymentsEntity();
//        OrdersEntity order = new OrdersEntity();
//        OrderDetailsEntity od = new OrderDetailsEntity();
//        auth.setName("Jyothsna");
//        auth.setDead(false);
//        auth.setAlias("Jyo");
//        publishers.setCompanyName("Penguin");
//        publishers.setCopyright(true);
//        customer.setAddress("3 Springdale Avenue");
//        customer.setDob(new Date(2000,01,31));
//        customer.setPhn("0000000000");
//        customer.setForename("Ammarah");
//        customer.setSurname("Iqbal");
//        customer.setEmail("ammarah@gmail.com");
//        genre.setFiction(true);
//        genre.setName("Fantasy");
//        book.setHardcover(true);
//        book.setIsbn(123);
//        book.setTitle("Da Vinci Code");
//        book.setIssue(123);
//        book.setPrice(99);
//        book.setQuantity(2);
//        book.setAuthor(auth);
//        pay.setAmount(99.99);
//        pay.setDate(new Date(2001,01,20));
//        order.setOrderDate(new Date(2000,01,01));
//        od.setQuantity(2);
//        od.setPpb(20);
//        Repo.save(auth);
//        RepoP.save(publishers);
//        RepoC.save(customer);
//        RepoG.save(genre);
//        RepoB.save(book);
//        RepoPay.save(pay);
//        RepoO.save(order);
//        return "Saved";
//    }

    @GetMapping("/save")
    public String CreateAuthor() {
        CustomersEntity customer = new CustomersEntity();
        PaymentsEntity pay = new PaymentsEntity();
        List<OrdersEntity> ordList = new ArrayList<OrdersEntity>();
        OrdersEntity ord = new OrdersEntity();
        pay.setAmount(111.111);
        pay.setDate(new Date(2001,01,20));
        ord.setOrderDate(new Date(2000,01,39));
        ord.setPayment(pay);
        ordList.add(ord);
        customer.setAddress("3 Springdale Avenue");
        customer.setDob(new Date(2000,01,31));
        customer.setPhn("0000000000");
        customer.setForename("Isobel");
        customer.setSurname("Iqbal");
        customer.setEmail("ammarah@gmail.com");
        customer.setOrders(ordList);
        RepoC.save(customer);
        //RepoPay.save(pay);
        return "Customer Details Added";
    }

    @GetMapping("/all")
    public List<CustomersEntity> Authors() {
        return RepoC.findAll();
    }

    /*@GetMapping("/allData")
    public AuthorEntity Authors_Data() {
        return Repo.findById(2);
    }*/
}
