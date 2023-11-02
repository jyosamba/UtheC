package com.UtheC2.UtheC2.Controllers;

import com.UtheC2.UtheC2.Entities.CustomersEntity;
import com.UtheC2.UtheC2.Services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class customersController {
    @Autowired
    private CustomerServices customerService;

    @GetMapping("/customers-dob/{customerID}")
    public ResponseEntity<?> getDOBbyCustomer(@PathVariable int customerID){
        List<CustomersEntity> DOBList = customerService.findDOBbyCustomerID(customerID);

        if(DOBList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No DOB found for the '"+customerID+"' Sorry!!");
        }
        return ResponseEntity.ok(DOBList);
    }

//    @GetMapping("/customers-forename/{customerID}")
//    public ResponseEntity<?> getDOBbyCustomer(@PathVariable int customerID){
//        List<CustomersEntity> DOBList = customerService.findDOBbyCustomerID(customerID);
//
//        if(DOBList.isEmpty()){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No DOB found for the '"+customerID+"' Sorry!!");
//        }
//        return ResponseEntity.ok(DOBList);
//    }

}
