package com.UtheC2.UtheC2.Services;

import com.UtheC2.UtheC2.Entities.CustomersEntity;
import com.UtheC2.UtheC2.repos.CustomersRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServices {
    private CustomersRepo RepoC;

    public List<CustomersEntity> findDOBbyCustomerID(int customerID){
        //Retrieving DOB depending on a specific Customer
        List<CustomersEntity> DOBList = RepoC.findByCustomerID(customerID);
        return DOBList;
    }

}
