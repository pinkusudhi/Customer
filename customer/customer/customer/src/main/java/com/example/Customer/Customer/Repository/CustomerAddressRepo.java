package com.example.Customer.Customer.Repository;

import com.example.Customer.Customer.Entity.CustomerAddressEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAddressRepo extends JpaRepository<CustomerAddressEntity,Long> {

    //@Query("select a from CustomerAddressEntity a where a.postalCode=:postalCode")
    @Query(value = "select * from customer_address where postal_code = :postal_code",nativeQuery = true)
    public CustomerAddressEntity GetCustomerAddressEntityByPostalCode(@Param("postal_code") String postalCode);
}
