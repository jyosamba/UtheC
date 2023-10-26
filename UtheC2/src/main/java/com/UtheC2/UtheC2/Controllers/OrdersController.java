package com.UtheC2.UtheC2.Controllers;

import com.UtheC2.UtheC2.Entities.BooksEntity;
import com.UtheC2.UtheC2.Entities.OrdersEntity;
import com.UtheC2.UtheC2.Services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;


    @GetMapping("/allOrders")
    public ResponseEntity<?> getOrders(){
        List<OrdersEntity> ordersList = ordersService.getAllOrders();

        if(ordersList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No books found");
        }

        return ResponseEntity.ok(ordersList);
    }

    @GetMapping("/{orderID}")
    public ResponseEntity<?> getOrdersbyOrderID(@PathVariable int orderID){
        List<OrdersEntity> booksList = ordersService.getOrdersbyOrderID(orderID);

        if(booksList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No orders found for the '"+orderID+"' genre. Sorry!!");
        }

        return ResponseEntity.ok(booksList);
    }

    @PostMapping("/createorder")
    public ResponseEntity<OrdersEntity> createOrder(@RequestBody OrdersEntity order){
        OrdersEntity createdOrder = ordersService.createOrder(order);

        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }
}
