package com.UtheC2.UtheC2.Controllers;

import com.UtheC2.UtheC2.Entities.*;
import com.UtheC2.UtheC2.Services.OrderDetailsService;
import com.UtheC2.UtheC2.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/orderdetails")
public class OrderDetailsController {

    private OrderDetailsService orderDetailsService;
    @Autowired
    OrderDetailsRepo RepoOD;

    @PostMapping("/createorderdetails")
    public ResponseEntity<OrderDetailsEntity> createOrder(@RequestBody OrderDetailsEntity orderDetails){
        OrderDetailsEntity createdOrderDetails = orderDetailsService.createOrderDetails(orderDetails);

        return new ResponseEntity<>(createdOrderDetails, HttpStatus.CREATED);
    }

    @GetMapping("/allOrderDetails")
    public ResponseEntity<?> getOrderDetails(){
        List<OrderDetailsEntity> orderDetailsList = orderDetailsService.getAllOrderDetails();

        if(orderDetailsList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No order details found");
        }

        return ResponseEntity.ok(orderDetailsList);
    }

    @GetMapping("/{orderDetailsID}")
    public ResponseEntity<?> getOrdersDetailsbyOrderDetailsID(@PathVariable int orderDetailsID){
        List<OrderDetailsEntity> orderDetailsList = orderDetailsService.getOrderDetailsbyOrderID(orderDetailsID);

        if(orderDetailsList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No order details found for the '"+orderDetailsID+"'. Sorry!!");
        }

        return ResponseEntity.ok(orderDetailsList);
    }
}
