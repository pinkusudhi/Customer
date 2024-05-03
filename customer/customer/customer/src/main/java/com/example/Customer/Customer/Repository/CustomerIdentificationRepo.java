package com.example.Customer.Customer.Repository;

import com.example.Customer.Customer.Entity.CustomerIdentificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerIdentificationRepo extends JpaRepository<CustomerIdentificationEntity,Long> {

}
