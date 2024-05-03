package com.example.Customer.Customer.Service;

import com.example.Customer.Customer.Entity.CustomerAddressEntity;
import com.example.Customer.Customer.Entity.CustomerEntity;
import com.example.Customer.Customer.Repository.CustomerAddressRepo;
import com.example.Customer.Customer.Request.CustomerAddressRequest;
import com.example.Customer.Customer.Responce.CustomerAddressResponce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@Slf4j
public class CustomerAddressService  {

    private static final Logger logger = Logger.getLogger(CustomerAddressService.class.getName());

    @Autowired
    public CustomerAddressRepo customerAddressRepo;

    public CustomerAddressResponce CreatecustomerAddress(CustomerAddressRequest customerAddressRequest) {
        logger.info("First, you need to get the data from customerAddressRequest and set it in the entity class");
        CustomerAddressEntity customerAddressEntity = new CustomerAddressEntity();
        customerAddressEntity.setStreet(customerAddressRequest.getStreet());
        customerAddressEntity.setCity(customerAddressRequest.getCity());
        customerAddressEntity.setState(customerAddressRequest.getState());
        customerAddressEntity.setPostalCode(customerAddressRequest.getPostalCode());
        customerAddressEntity.setCountry(customerAddressRequest.getCountry());

        logger.info("You need to save the data first from CustomerAddressEntity obtained from customerAddressRequest");
        CustomerAddressEntity savedCustomerAddressEntity = customerAddressRepo.save(customerAddressEntity);

        logger.info("After saving, you need to set the response based on the saved entity");
        CustomerAddressResponce customerAddressResponce = new CustomerAddressResponce();
        customerAddressResponce.setCity(savedCustomerAddressEntity.getCity());
        customerAddressResponce.setCountry(savedCustomerAddressEntity.getCountry());
        customerAddressResponce.setPostalCode(savedCustomerAddressEntity.getPostalCode());
        customerAddressResponce.setStreet(savedCustomerAddressEntity.getStreet());
        customerAddressResponce.setState(savedCustomerAddressEntity.getState());
        customerAddressResponce.setAddressId(savedCustomerAddressEntity.getAddressId());

        return customerAddressResponce;
    }
    public CustomerAddressResponce GetCustomerAddressById(Long id)
    {
        logger.info("first you need to get id from CustomerAddressEntity");
        CustomerAddressEntity customerAddressEntity=new CustomerAddressEntity();
        customerAddressEntity=this.customerAddressRepo.findById(id).orElse(null);
        logger.info("you find the id after thet you need to set the responce");
            CustomerAddressResponce customerAddressResponce=new CustomerAddressResponce();
            customerAddressResponce.setStreet(customerAddressEntity.getStreet());
            customerAddressResponce.setCountry(customerAddressEntity.getCountry());
            customerAddressResponce.setState(customerAddressEntity.getState());
            customerAddressResponce.setPostalCode(customerAddressEntity.getPostalCode());
            customerAddressResponce.setCity(customerAddressEntity.getCity());
            customerAddressResponce.setAddressId(customerAddressEntity.getAddressId());
        return customerAddressResponce;
    }

    public List<CustomerAddressResponce>GetAllCustomerAddress()
    {
        logger.info("first you need to return customerAddressEntities");
        List<CustomerAddressEntity>customerAddressEntities=this.customerAddressRepo.findAll();
        logger.info("creating a empty list for adding List of customerAddressResponces");
        List<CustomerAddressResponce>customerAddressResponces=new ArrayList<>();
        logger.info("after that you can converted List of customerAddressEntities into single customerAddressEntity");
        for (CustomerAddressEntity customerAddressEntity:customerAddressEntities)
        {
            logger.info("create the single responce and return the list of responce");
            CustomerAddressResponce customerAddressResponce=new CustomerAddressResponce();
            customerAddressResponce.setAddressId(customerAddressEntity.getAddressId());
            customerAddressResponce.setCity(customerAddressEntity.getCity());
            customerAddressResponce.setState(customerAddressEntity.getState());
            customerAddressResponce.setStreet(customerAddressEntity.getStreet());
            customerAddressResponce.setCountry(customerAddressEntity.getCountry());
            customerAddressResponce.setPostalCode(customerAddressEntity.getPostalCode());
            customerAddressResponces.add(customerAddressResponce);
        }
        return customerAddressResponces;
    }

    public CustomerAddressResponce updateCustomerAddress(CustomerAddressEntity updatedAddressEntity, Long id)throws Exception
    {
        logger.info("first you need to find the id ");
        Optional<CustomerAddressEntity>customerAddressEntityOptional=this.customerAddressRepo.findById(id);
        if (customerAddressEntityOptional.isPresent()) {
            logger.info("if id is present you can get the update and set the data into exiting id field");
            CustomerAddressEntity exitsingAddressEntity = customerAddressEntityOptional.get();
            logger.info("get the id and store the id in exitsingAddressEntity");
            exitsingAddressEntity.setState(updatedAddressEntity.getState());
            exitsingAddressEntity.setStreet(updatedAddressEntity.getStreet());
            exitsingAddressEntity.setCity(updatedAddressEntity.getCity());
            exitsingAddressEntity.setPostalCode(updatedAddressEntity.getPostalCode());
            exitsingAddressEntity.setCountry(updatedAddressEntity.getCountry());
            logger.info("before update ");
            CustomerAddressEntity savedCustomerAddress=customerAddressRepo.save(exitsingAddressEntity);
            logger.info("after update data saved ");
            CustomerAddressResponce customerAddressResponce=new CustomerAddressResponce();
            customerAddressResponce.setAddressId(savedCustomerAddress.getAddressId());
            customerAddressResponce.setCountry(savedCustomerAddress.getCountry());
            customerAddressResponce.setCity(savedCustomerAddress.getCity());
            customerAddressResponce.setState(savedCustomerAddress.getState());
            customerAddressResponce.setStreet(savedCustomerAddress.getStreet());
            customerAddressResponce.setPostalCode(savedCustomerAddress.getPostalCode());
            return customerAddressResponce;
        }
        return null;
    }
    public List<CustomerAddressResponce>deleteCustomerAddressById(Long id)
    {
        CustomerAddressEntity customerAddressEntity=customerAddressRepo.findById(id).orElse(null);
        if (customerAddressEntity!=null)
        {
           customerAddressRepo.delete(customerAddressEntity);
           List<CustomerAddressResponce>addressResponces=new ArrayList<>();
           List<CustomerAddressEntity>customerAddressEntities=customerAddressRepo.findAll();
           for (CustomerAddressEntity customerAddressEntity1:customerAddressEntities)
           {
               CustomerAddressResponce customerAddressResponce=new CustomerAddressResponce();
               customerAddressResponce.setAddressId(customerAddressEntity1.getAddressId());
               customerAddressResponce.setStreet(customerAddressEntity1.getStreet());
               customerAddressResponce.setPostalCode(customerAddressEntity1.getPostalCode());
               customerAddressResponce.setState(customerAddressEntity1.getState());
               customerAddressResponce.setCity(customerAddressEntity1.getCity());
               customerAddressResponce.setCountry(customerAddressEntity1.getCountry());
               addressResponces.add(customerAddressResponce);
               return addressResponces;
           }
        }
        return null;
    }
    public CustomerAddressResponce findCustomerAddressByPostalcode(String postalCode)
    {
        CustomerAddressEntity customerAddressEntity=customerAddressRepo.GetCustomerAddressEntityByPostalCode(postalCode);
        CustomerAddressResponce customerAddressResponce=new CustomerAddressResponce();
        customerAddressResponce.setAddressId(customerAddressEntity.getAddressId());
        customerAddressResponce.setCountry(customerAddressEntity.getCountry());
        customerAddressResponce.setCity(customerAddressEntity.getCity());
        customerAddressResponce.setState(customerAddressEntity.getState());
        customerAddressResponce.setStreet(customerAddressEntity.getStreet());
        customerAddressResponce.setPostalCode(customerAddressEntity.getPostalCode());
        return customerAddressResponce;
    }
}
