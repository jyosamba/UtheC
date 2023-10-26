package com.UtheC2.UtheC2.repos;

import com.UtheC2.UtheC2.Entities.BooksEntity;
import com.UtheC2.UtheC2.Entities.OrdersEntity;
import jakarta.persistence.criteria.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepo extends JpaRepository<OrdersEntity,Integer> {
    List<OrdersEntity> findOrderByOrderID(int OrderID);
}
