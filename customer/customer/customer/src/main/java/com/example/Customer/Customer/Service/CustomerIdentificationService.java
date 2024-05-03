package com.example.Customer.Customer.Service;

import com.example.Customer.Customer.Entity.CustomerIdentificationEntity;
import com.example.Customer.Customer.Repository.CustomerIdentificationRepo;
import com.example.Customer.Customer.Request.CustomerIdentificationRequest;
import com.example.Customer.Customer.Responce.CustomerAddressResponce;
import com.example.Customer.Customer.Responce.CustomerIdentificationResponce;
import com.example.Customer.Customer.Responce.CustomerResponce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@Slf4j
public class CustomerIdentificationService {

    private static final Logger logger = Logger.getLogger(CustomerIdentificationService.class.getName());

    @Autowired
    public CustomerIdentificationRepo customerIdentificationRepo;

    public CustomerIdentificationResponce CreateCustomerIdentification( CustomerIdentificationRequest customerIdentificationRequest)
    {
        CustomerIdentificationEntity customerIdentificationEntity = new CustomerIdentificationEntity();

        customerIdentificationEntity.setIdNumber(customerIdentificationRequest.getIdNumber());
        customerIdentificationEntity.setIdType(customerIdentificationRequest.getIdType());
        customerIdentificationEntity.setIssuingCountry(customerIdentificationRequest.getIssuingCountry());

        CustomerIdentificationEntity savedCustomerIdentificationEntity = customerIdentificationRepo.save(customerIdentificationEntity);
        CustomerIdentificationResponce customerIdentificationResponce = new CustomerIdentificationResponce();
        customerIdentificationResponce.setIdNumber(savedCustomerIdentificationEntity.getIdNumber());
        customerIdentificationResponce.setIdType(savedCustomerIdentificationEntity.getIdType());
        customerIdentificationResponce.setIssuingCountry(savedCustomerIdentificationEntity.getIssuingCountry());
        return customerIdentificationResponce;
    }
    public List<CustomerIdentificationResponce> getAllCustomerIdentification()
    {
        List<CustomerIdentificationEntity>customerIdentificationEntities=customerIdentificationRepo.findAll();
        List<CustomerIdentificationResponce>customerIdentificationResponces=new ArrayList<>();
        for (CustomerIdentificationEntity customerIdentificationEntity:customerIdentificationEntities)
        {
            CustomerIdentificationResponce customerIdentificationResponce=new CustomerIdentificationResponce();
            customerIdentificationResponce.setIdNumber(customerIdentificationEntity.getIdNumber());
            customerIdentificationResponce.setIssuingCountry(customerIdentificationEntity.getIssuingCountry());
            customerIdentificationResponce.setIdType(customerIdentificationEntity.getIdType());
            customerIdentificationResponces.add(customerIdentificationResponce);
        }
        return customerIdentificationResponces;
    }
    public List<CustomerIdentificationResponce>deleteCustomerIdentificationById(Long id) {
        Optional<CustomerIdentificationEntity> customerIdentificationEntity = customerIdentificationRepo.findById(id);
        List<CustomerIdentificationResponce> customerIdentificationResponces = new ArrayList<>();
        if (customerIdentificationEntity.isPresent()) {
            CustomerIdentificationEntity customerIdentificationEntity1 = customerIdentificationEntity.get();
            customerIdentificationRepo.delete(customerIdentificationEntity1);
            List<CustomerIdentificationEntity> customerIdentificationEntities = customerIdentificationRepo.findAll();
            for (CustomerIdentificationEntity customerIdentificationEntity2 : customerIdentificationEntities) {
                CustomerIdentificationResponce customerIdentificationResponce = new CustomerIdentificationResponce();
                customerIdentificationResponce.setIdType(customerIdentificationEntity2.getIdType());
                customerIdentificationResponce.setIdNumber(customerIdentificationEntity2.getIdNumber());
                customerIdentificationResponce.setIssuingCountry(customerIdentificationEntity2.getIssuingCountry());
                customerIdentificationResponces.add(customerIdentificationResponce);
            }
        }
        return customerIdentificationResponces;
    }
    public CustomerIdentificationResponce getCustomerIdentificationById(Long id)
    {
       Optional<CustomerIdentificationEntity>customerIdentificationEntity=customerIdentificationRepo.findById(id);
       if (customerIdentificationEntity.isPresent())
       {
           CustomerIdentificationEntity customerIdentificationEntity1=customerIdentificationEntity.get();
           CustomerIdentificationResponce customerIdentificationResponce=new CustomerIdentificationResponce();
           customerIdentificationResponce.setIdNumber(customerIdentificationEntity1.getIdNumber());
           customerIdentificationResponce.setIdType(customerIdentificationEntity1.getIdType());
           customerIdentificationResponce.setIssuingCountry(customerIdentificationEntity1.getIssuingCountry());
           return customerIdentificationResponce;
       }
        return null;
    }
    public CustomerIdentificationResponce UpdateCustomerIdentification(CustomerIdentificationEntity updatecustomerIdentificationEntity,Long id)
    {
        Optional<CustomerIdentificationEntity> customerIdentificationEntity=customerIdentificationRepo.findById(id);
        if (customerIdentificationEntity.isPresent())
        {
            CustomerIdentificationEntity ExitsingIdentificationEntity=customerIdentificationEntity.get();
            ExitsingIdentificationEntity.setIdType(updatecustomerIdentificationEntity.getIdType());
            ExitsingIdentificationEntity.setIdNumber(updatecustomerIdentificationEntity.getIdNumber());
            ExitsingIdentificationEntity.setIssuingCountry(updatecustomerIdentificationEntity.getIssuingCountry());
            CustomerIdentificationEntity savedCustomerIdentification=this.customerIdentificationRepo.save(ExitsingIdentificationEntity);
            CustomerIdentificationResponce customerIdentificationResponce=new CustomerIdentificationResponce();
            customerIdentificationResponce.setIdType(savedCustomerIdentification.getIdType());
            customerIdentificationResponce.setIssuingCountry(savedCustomerIdentification.getIssuingCountry());
            customerIdentificationResponce.setIdNumber(savedCustomerIdentification.getIdNumber());
            return customerIdentificationResponce;
        }
        return null;
    }
}
