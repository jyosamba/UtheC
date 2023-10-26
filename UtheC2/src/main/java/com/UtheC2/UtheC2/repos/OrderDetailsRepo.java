package com.UtheC2.UtheC2.repos;

import com.UtheC2.UtheC2.Entities.OrderDetailsEntity;
import com.UtheC2.UtheC2.Entities.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailsRepo extends JpaRepository<OrderDetailsEntity,Integer> {
    List<OrderDetailsEntity> findOrderDetailsByOrderDetailsID(int orderDetailsID);
}
