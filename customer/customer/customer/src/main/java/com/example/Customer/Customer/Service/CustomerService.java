package com.example.Customer.Customer.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import com.example.Customer.Customer.Entity.CustomerEntity;
import com.example.Customer.Customer.Repository.CustomerRepo;
import com.example.Customer.Customer.Request.CustomerRequest;
import com.example.Customer.Customer.Responce.CustomerResponce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerService {

	private static final Logger logger = Logger.getLogger(CustomerService.class.getName());

	@Autowired
	public CustomerRepo customerRepo;
	
	public CustomerResponce createCustomer(CustomerRequest customerRequest) throws Exception
	{
			CustomerEntity customerEntity = new CustomerEntity();
			customerEntity.setFullName(customerRequest.getFullName());
			customerEntity.setGender(customerRequest.getGender());

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dob = dateFormat.parse(customerRequest.getDateOfBirth());
			customerEntity.setDateOfBirth(dob);
			customerEntity.setNationality(customerRequest.getNationality());
			customerEntity.setEmailAddress(customerRequest.getEmailAddress());
			customerEntity.setPhoneNumber(customerRequest.getPhoneNumber());
			CustomerEntity customerEntity1=customerRepo.save(customerEntity);
			CustomerResponce customerResponce=new CustomerResponce();
			customerResponce.setFullName(customerEntity1.getFullName());
			customerResponce.setGender(customerEntity1.getGender());
			customerResponce.setNationality(customerEntity1.getNationality());
			customerResponce.setEmailAddress(customerEntity1.getEmailAddress());
			customerResponce.setDateOfBirth(customerEntity1.getDateOfBirth());
			customerResponce.setPhoneNumber(customerEntity1.getPhoneNumber());
		return customerResponce ;
	}
	public CustomerEntity GetCustomerId(Long customerId)throws Exception
	{
		//CustomerResponce customerResponce = new CustomerResponce();
		CustomerEntity customer = new CustomerEntity();
		customer=customerRepo.findById(customerId).orElse(null);
		return customer;
	}
	public List<CustomerResponce>getAllCustomer()
	{
		List<CustomerEntity>customerEntities=new ArrayList<>();
		customerEntities=customerRepo.findAll();
		List<CustomerResponce>customerResponces=new ArrayList<>();
		for (CustomerEntity customerEntity:customerEntities)
		{
			CustomerResponce customerResponce=new CustomerResponce();
			customerResponce.setCustomerId(customerEntity.getCustomerId());
			customerResponce.setFullName(customerEntity.getFullName());
			customerResponce.setGender(customerEntity.getGender());
			customerResponce.setNationality(customerEntity.getNationality());
			customerResponce.setEmailAddress(customerEntity.getEmailAddress());
			customerResponce.setDateOfBirth(customerEntity.getDateOfBirth());
			customerResponce.setPhoneNumber(customerEntity.getPhoneNumber());
			customerResponces.add(customerResponce);
		}
		return customerResponces;
	}

	public CustomerEntity getCustomerByPhone(String phoneNumber)
	{
		CustomerEntity customer = new CustomerEntity();
		customer=customerRepo.getCustomerByPhoneNu(phoneNumber);
		return customer;
	}
	public CustomerResponce customerUpdateById(CustomerEntity updatedCustomer,Long id)
	{
		Optional<CustomerEntity>customerEntity=customerRepo.findById(id);
		if (customerEntity.isPresent())
		{
			CustomerEntity existingCustomer=customerEntity.get();
			existingCustomer.setFullName(updatedCustomer.getFullName());
			existingCustomer.setPhoneNumber(updatedCustomer.getPhoneNumber());
			existingCustomer.setEmailAddress(updatedCustomer.getEmailAddress());
			existingCustomer.setNationality(updatedCustomer.getNationality());
			existingCustomer.setGender(updatedCustomer.getGender());
			existingCustomer.setDateOfBirth(updatedCustomer.getDateOfBirth());
			CustomerEntity savedCustomer=this.customerRepo.save(existingCustomer);
			CustomerResponce customerResponce=new CustomerResponce();
			customerResponce.setCustomerId(savedCustomer.getCustomerId());
			customerResponce.setFullName(savedCustomer.getFullName());
			customerResponce.setPhoneNumber(savedCustomer.getPhoneNumber());
			customerResponce.setGender(savedCustomer.getGender());
			customerResponce.setNationality(savedCustomer.getNationality());
			customerResponce.setEmailAddress(savedCustomer.getEmailAddress());
			customerResponce.setDateOfBirth(savedCustomer.getDateOfBirth());
			return customerResponce;
		}
		return null;
	}
	public List<CustomerResponce> deleteById(Long id)
	{
		CustomerEntity customerToDelete=new CustomerEntity();
		customerToDelete=customerRepo.findById(id).orElse(null);
		if (customerToDelete!=null)
		{
			customerRepo.delete(customerToDelete);
		}
		List<CustomerEntity>remainingCustomers =new ArrayList<>();
		remainingCustomers=customerRepo.findAll();
		List<CustomerResponce>remainingResponses=new ArrayList<>();
		for(CustomerEntity customerEntity:remainingCustomers)
		{
			CustomerResponce customerResponce=new CustomerResponce();
			customerResponce.setCustomerId(customerEntity.getCustomerId());
			customerResponce.setGender(customerEntity.getGender());
			customerResponce.setNationality(customerEntity.getNationality());
			customerResponce.setEmailAddress(customerEntity.getEmailAddress());
			customerResponce.setFullName(customerEntity.getFullName());
			customerResponce.setPhoneNumber(customerEntity.getPhoneNumber());
			customerResponce.setDateOfBirth(customerEntity.getDateOfBirth());
			remainingResponses.add(customerResponce);
			return remainingResponses;
		}
		return null;
	}
	public CustomerEntity findCustomerByFullname(String fullName)
	{
		CustomerEntity customerEntity=customerRepo.getCustomerByFullName(fullName);
		if (customerEntity!=null)
		{
			return customerEntity;
		}
		return null;
	}
}
