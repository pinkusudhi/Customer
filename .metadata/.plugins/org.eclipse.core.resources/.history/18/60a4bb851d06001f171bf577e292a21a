package com.example.Customer.Customer.Controller;

import com.example.Customer.Customer.Constant.Constant;
import com.example.Customer.Customer.Entity.CustomerEntity;
import com.example.Customer.Customer.Request.CustomerRequest;
import com.example.Customer.Customer.Responce.CustomerResponce;
import com.example.Customer.Customer.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(Constant.post)
    public ResponseEntity<CustomerResponce>createCustomer(@RequestBody CustomerRequest customerRequest) throws Exception {

        CustomerResponce customerResponce=customerService.createCustomer(customerRequest);

        if (customerResponce!=null)
        {
            return new ResponseEntity<>(customerResponce,HttpStatus.CREATED);
        }
        return null;
    }
    @GetMapping(Constant.get)
    public ResponseEntity<CustomerEntity>getCustomerById(@PathVariable Long customerId) throws Exception {
        CustomerEntity customerEntity=new CustomerEntity();
        customerEntity=customerService.GetCustomerId(customerId);
        if (customerEntity!=null)
        {
            return new ResponseEntity<>(customerEntity,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(Constant.getAll)
    public ResponseEntity<List<CustomerResponce>>getAllCustmer()
    {
     List<CustomerResponce>customerResponces=new ArrayList<>();
     customerResponces=this.customerService.getAllCustomer();
      if (customerResponces!=null)
      {
          return new ResponseEntity<>(customerResponces,HttpStatus.OK);
      }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/customer/{phoneNu}")
    public ResponseEntity<CustomerEntity> getCustomerByPhoneNu(@PathVariable("phoneNu") String phoneNumber)
    {
        CustomerEntity customer=new CustomerEntity();
        customer=customerService.getCustomerByPhone(phoneNumber);
        if(customer!=null)
        {
            return new ResponseEntity<>(customer,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(Constant.updateCustomer)
    public ResponseEntity<CustomerResponce>updateCustomer(@RequestBody CustomerEntity updatedCustomer,@PathVariable Long id)
    {
        CustomerResponce customerResponce=new CustomerResponce();
        customerResponce = customerService.customerUpdateById(updatedCustomer,id);
        if (customerResponce!=null)
        {
            return new ResponseEntity<>(customerResponce,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping(Constant.deleteCustomer)
    public ResponseEntity<List<CustomerResponce>>deleteCustomerByid(@PathVariable("id") Long id)
    {
       List<CustomerResponce> customerResponce=customerService.deleteById(id);
        if (customerResponce!=null)
        {
            return new ResponseEntity<>(customerResponce,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(Constant.getCustomerByfullname)
    public ResponseEntity<CustomerEntity> getCustomerByfullname(@PathVariable("fullName") String fullName)
    {
        CustomerEntity customer=customerService.findCustomerByFullname(fullName);
        if (customer!=null)
        {
            return new ResponseEntity<>(customer,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
