package com.UtheC2.UtheC2.Controllers;

import com.UtheC2.UtheC2.Entities.*;
import com.UtheC2.UtheC2.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class OrderDetailsController {
    @Autowired
    OrderDetailsRepo RepoOD;

    @GetMapping("/OrderDetails")
    public List<OrderDetailsEntity> OrderDetails() {
        return RepoOD.findAll();
    }

    @GetMapping("/CreateOrderDetails")
    public String CreateNewOrderDetails(OrderDetailsEntity orderDetailsEntity){

        RepoOD.save(orderDetailsEntity);
        return "pass";
    }
}
