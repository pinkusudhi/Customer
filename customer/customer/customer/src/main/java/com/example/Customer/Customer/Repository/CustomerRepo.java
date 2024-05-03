package com.example.Customer.Customer.Repository;

import com.example.Customer.Customer.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface CustomerRepo extends JpaRepository <CustomerEntity,Long> {
    @Query(value = "SELECT * FROM Customer WHERE Phone_number = :Phone_number", nativeQuery = true)
    //@Query("SELECT C FROM CustomerEntity C WHERE  C.Phone_number=:Phone_number")
    public CustomerEntity getCustomerByPhoneNu(@Param("Phone_number") String phoneNumber);

    @Query("select c from CustomerEntity c where c.fullName=:fullName")
    public CustomerEntity getCustomerByFullName(@Param("fullName") String fullName);
}
