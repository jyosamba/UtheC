package com.UtheC2.UtheC2.Services;

import com.UtheC2.UtheC2.Entities.OrderDetailsEntity;
import com.UtheC2.UtheC2.Entities.OrdersEntity;
import com.UtheC2.UtheC2.repos.OrderDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderDetailsService {
    @Autowired
    private OrderDetailsRepo RepoOD;

    public List<OrderDetailsEntity> getAllOrderDetails(){
        List<OrderDetailsEntity> orderDetailsList = RepoOD.findAll();

        return orderDetailsList;
    }

    public List<OrderDetailsEntity> getOrderDetailsbyOrderID(int orderDetailsID){
        List<OrderDetailsEntity> orderDetailsList = RepoOD.findOrderDetailsByOrderDetailsID(orderDetailsID);

        return orderDetailsList;
    }

    public OrderDetailsEntity createOrderDetails(OrderDetailsEntity order){
        return RepoOD.save(order);
    }
}
