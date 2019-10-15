package com.hd.cms.cms.api;

import com.hd.cms.cms.model.Customer;
import com.hd.cms.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/customers")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer addCustomer (@RequestBody Customer customer) {

        return customerService.addCustomer(customer);

    }

    @GetMapping
    public List<Customer> getCustomers (){

        return customerService.getCustomerList();

    }

    @GetMapping (value = "/{customerId}")
    public Customer getCustomer (@PathVariable("customerId") Long customerId){

        return customerService.getCustomerById(customerId);

    }

    @PutMapping (value = "/{customerId}")
    public Customer updateCustomer ( @PathVariable("customerId") Long customerId, @RequestBody Customer customer){

        return customerService.updateCustomer(customerId,customer);

    }

    @DeleteMapping (value = "/{customerId}")
    public void deleteCustomer ( @PathVariable("customerId") Long customerId){

        customerService.deleteCustomer(customerId);

    }

}
