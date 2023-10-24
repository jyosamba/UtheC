package com.UtheC2.UtheC2.repos;

import com.UtheC2.UtheC2.Entities.OrdersEntity;
import jakarta.persistence.criteria.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepo extends JpaRepository<OrdersEntity,Integer> {
}
