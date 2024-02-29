package com.bidirectional.login.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bidirectional.login.model.*;

public  interface LoginInformationRepo extends JpaRepository<LoginInformation,Integer>{
    @Modifying
    @Query(value = "update LoginInformation log set log.password=?2 where log.customerId=?1")
    void update(int customerId , String password);
}
