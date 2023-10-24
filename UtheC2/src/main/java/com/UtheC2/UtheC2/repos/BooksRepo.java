package com.UtheC2.UtheC2.repos;

import com.UtheC2.UtheC2.Entities.BooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepo extends JpaRepository<BooksEntity,Integer> {
}
