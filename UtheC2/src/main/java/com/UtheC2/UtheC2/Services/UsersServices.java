package com.UtheC2.UtheC2.Services;
import com.UtheC2.UtheC2.Entities.BooksEntity;
import com.UtheC2.UtheC2.Entities.CustomersEntity;
import com.UtheC2.UtheC2.Entities.OrdersEntity;
import com.UtheC2.UtheC2.Entities.UserEntity;
import com.UtheC2.UtheC2.repos.UserRepo;
import com.UtheC2.UtheC2.repos.CustomersRepo;
import com.UtheC2.UtheC2.repos.BooksRepo;
import com.UtheC2.UtheC2.repos.OrdersRepo;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersServices {

    @Autowired
    private UserRepo RepoU;

    public int getCustomerIdFromUser(String username, String password){
        UserEntity user = RepoU.findUserByuserName(username);
        return user.getCustomers().getCustomerID();
    }

    public UserEntity findUserByuserName(String username, String password){
       // List<OrdersEntity> ordersList = RepoO.findOrderByOrderID(orderID);
        //UserEntity myUser = RepoU.findUserByuserName(username, password);
        UserEntity myUser = RepoU.findUserByuserName("root");
        return myUser;
    }


}
