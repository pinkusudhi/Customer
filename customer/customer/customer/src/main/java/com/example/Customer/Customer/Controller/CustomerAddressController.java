package com.example.Customer.Customer.Controller;

import com.example.Customer.Customer.Constant.Constant;
import com.example.Customer.Customer.Entity.CustomerAddressEntity;
import com.example.Customer.Customer.Request.CustomerAddressRequest;
import com.example.Customer.Customer.Responce.CustomerAddressResponce;
import com.example.Customer.Customer.Service.CustomerAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class CustomerAddressController {

    private static final Logger logger = Logger.getLogger(CustomerAddressController.class.getName());

    @Autowired
    public CustomerAddressService customerAddressService;

    @PostMapping(Constant.CreateCustomerAddress)
    public ResponseEntity<CustomerAddressResponce> createCustomerAddress(@RequestBody CustomerAddressRequest customerAddressRequest)
    {
        CustomerAddressResponce customerAddressResponce=this.customerAddressService.CreatecustomerAddress(customerAddressRequest);
        if (customerAddressResponce!=null)
        {
            return new ResponseEntity<>(customerAddressResponce, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(Constant.GetcustomerAddressbyId)
    public ResponseEntity<CustomerAddressResponce> getCustomerAddressById(@PathVariable("id") Long id)
    {
        CustomerAddressResponce customerAddressResponces=this.customerAddressService.GetCustomerAddressById(id);
        if (customerAddressResponces!=null)
        {
            return new ResponseEntity<>(customerAddressResponces,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/GetAllCustomerAddress")
    public ResponseEntity<List<CustomerAddressResponce>>GetAllCustomerAddress()
    {
        List<CustomerAddressResponce>customerAddressResponces=customerAddressService.GetAllCustomerAddress();
        if (customerAddressResponces!=null)
        {
            return new ResponseEntity<>(customerAddressResponces,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
@PutMapping(Constant.UpdatecustomerAddressbyId)
    public ResponseEntity<CustomerAddressResponce> updateCustomerAddress(@RequestBody CustomerAddressEntity customerAddressEntity, @PathVariable("id") Long id) throws Exception {
        CustomerAddressResponce customerAddressResponce=new CustomerAddressResponce();
        customerAddressResponce=this.customerAddressService.updateCustomerAddress(customerAddressEntity,id);
        if (customerAddressResponce!=null)
        {
            return new ResponseEntity<>(customerAddressResponce,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping(Constant.deleteCustomerAddress)
    public ResponseEntity<List<CustomerAddressResponce>>deleteCustomerAddress(@PathVariable("id") Long id)
    {
        List<CustomerAddressResponce>addressResponces=customerAddressService.deleteCustomerAddressById(id);
        if (addressResponces!=null)
        {
            return new ResponseEntity<>(addressResponces,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(Constant.getCustomerAddressByPostalcode)
    public ResponseEntity<CustomerAddressResponce>getCustomerAddressByPostalcode(@PathVariable("postalCode")String postalCode)
    {
        CustomerAddressResponce customerAddressResponce=new CustomerAddressResponce();
        customerAddressResponce=customerAddressService.findCustomerAddressByPostalcode(postalCode);
        if (customerAddressResponce!=null)
        {
            return new ResponseEntity<>(customerAddressResponce,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
