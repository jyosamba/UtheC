package com.UtheC2.UtheC2.Controllers;

import com.UtheC2.UtheC2.Entities.CustomersEntity;
import com.UtheC2.UtheC2.Entities.UserEntity;
import com.UtheC2.UtheC2.Services.BookServices;
import com.UtheC2.UtheC2.Services.UsersServices;
import com.UtheC2.UtheC2.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
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

    @Autowired
    UsersServices usersServices;

    @Autowired
    BookServices bookServices;


    //Find customer from login user
    //1. find customerid from user <<-- up to here
    //2. find customer from customerid
    @GetMapping("/customerInfo")
    public CustomersEntity findUserByUsername(@PathVariable UserEntity user){
        int custID = usersServices.getCustomerIdFromUser(user.getUserName(), user.getPwd());
        //2: plug in custID
        return null;
    }

    //Add book to basket
    //1. Find book by book id
    //2. Add bookEntity to basket
    @GetMapping("/AddToBasket")
    public String addBookToBasket(){
        //plug in frontend data
        bookServices.getBookBybookID(1);
        //add to basket
        return null;}

    //view basket contents
    @GetMapping("/viewBasket")
    public String method(){return null;}

    /** ToDo
     * add a book to the basket
     * retrieve the relevant customer info
     * **/


}
