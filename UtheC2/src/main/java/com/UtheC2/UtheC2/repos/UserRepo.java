package com.UtheC2.UtheC2.repos;

import com.UtheC2.UtheC2.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,String> {


}
