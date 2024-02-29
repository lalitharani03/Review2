package com.bidirectional.login.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bidirectional.login.model.*;

public interface LoginRepo extends JpaRepository<Login,Integer>{
    
}
