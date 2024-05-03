package com.example.Customer.Customer.Controller;

import com.example.Customer.Customer.Constant.Constant;
import com.example.Customer.Customer.Entity.CustomerIdentificationEntity;
import com.example.Customer.Customer.Request.CustomerIdentificationRequest;
import com.example.Customer.Customer.Responce.CustomerIdentificationResponce;
import com.example.Customer.Customer.Service.CustomerIdentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class CustomerIdentificationController {

    private static final Logger logger = Logger.getLogger(CustomerIdentificationController.class.getName());

    @Autowired
    public CustomerIdentificationService customerIdentificationService;

    @PostMapping(Constant.createCustomerIdentification)
    public ResponseEntity<CustomerIdentificationResponce>createCustomerIdentification(@RequestBody CustomerIdentificationRequest customerIdentificationRequest)
    {
        CustomerIdentificationResponce customerIdentificationResponce=new CustomerIdentificationResponce();
        customerIdentificationResponce=this.customerIdentificationService.CreateCustomerIdentification(customerIdentificationRequest);
        if (customerIdentificationResponce!=null)
        {
            return new ResponseEntity<>(customerIdentificationResponce,HttpStatus.CREATED);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(Constant.getAllCustomerIdentification)
    public ResponseEntity<List<CustomerIdentificationResponce>>getAllCustomeridentification()
    {
        List<CustomerIdentificationResponce>customerIdentificationResponces=customerIdentificationService.getAllCustomerIdentification();
        if (customerIdentificationResponces!=null)
        {
            return new ResponseEntity<>(customerIdentificationResponces,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping(Constant.deleteCustomerIdentificationByid)
    public ResponseEntity<List<CustomerIdentificationResponce>>deleteCustomerIdentificationByid(@PathVariable("id")Long id)
    {
        List<CustomerIdentificationResponce>customerIdentificationResponces=customerIdentificationService.deleteCustomerIdentificationById(id);
        if (customerIdentificationResponces!=null)
        {
            return new ResponseEntity<>(customerIdentificationResponces,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(Constant.getCustomerIdentificationById)
    public ResponseEntity<CustomerIdentificationResponce>getCustomerIdentificationByid(@PathVariable("id") Long id)
    {
        CustomerIdentificationResponce customerIdentificationResponce=new CustomerIdentificationResponce();
        customerIdentificationResponce=customerIdentificationService.getCustomerIdentificationById(id);
        if (customerIdentificationResponce==null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerIdentificationResponce,HttpStatus.OK);
    }
    @PutMapping(Constant.updateCustomerIdentificationById)
    public ResponseEntity<CustomerIdentificationResponce>updateCustomerIdentificationById(@RequestBody CustomerIdentificationEntity customerIdentificationEntity,@PathVariable("id") Long id)
    {
        CustomerIdentificationResponce customerIdentificationResponce=new CustomerIdentificationResponce();
        customerIdentificationResponce=this.customerIdentificationService.UpdateCustomerIdentification(customerIdentificationEntity,id);
        if (customerIdentificationResponce!=null)
        {
            return new ResponseEntity<>(customerIdentificationResponce,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
