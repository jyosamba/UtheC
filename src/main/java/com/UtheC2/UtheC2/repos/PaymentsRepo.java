package com.UtheC2.UtheC2.repos;

import com.UtheC2.UtheC2.Entities.PaymentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentsRepo extends JpaRepository<PaymentsEntity,Integer> {
}
