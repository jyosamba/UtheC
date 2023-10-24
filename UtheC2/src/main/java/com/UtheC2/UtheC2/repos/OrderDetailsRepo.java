package com.UtheC2.UtheC2.repos;

import com.UtheC2.UtheC2.Entities.OrderDetailsEntity;
import com.UtheC2.UtheC2.Entities.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepo extends JpaRepository<OrderDetailsEntity,Integer> {
}
