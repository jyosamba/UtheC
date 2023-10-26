package com.UtheC2.UtheC2.Services;

import com.UtheC2.UtheC2.Entities.BooksEntity;
import com.UtheC2.UtheC2.Entities.OrdersEntity;
import com.UtheC2.UtheC2.repos.BooksRepo;
import com.UtheC2.UtheC2.repos.OrdersRepo;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepo RepoO;

    public List<OrdersEntity> getAllOrders(){
        List<OrdersEntity> ordersList = RepoO.findAll();

        return ordersList;
    }

    public List<OrdersEntity> getOrdersbyOrderID(int orderID){
        List<OrdersEntity> ordersList = RepoO.findOrderByOrderID(orderID);

        return ordersList;
    }

    public OrdersEntity createOrder(OrdersEntity order){
        return RepoO.save(order);
    }
}
