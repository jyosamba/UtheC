package com.UtheC2.UtheC2.repos;

import com.UtheC2.UtheC2.Entities.CustomersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomersRepo extends JpaRepository<CustomersEntity,Integer> {
    List<CustomersEntity> findByCustomersCustomersID(int customerID);
}
