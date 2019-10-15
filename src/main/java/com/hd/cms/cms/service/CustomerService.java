package com.hd.cms.cms.service;

import com.hd.cms.cms.dao.CustomerDAO;
import com.hd.cms.cms.exception.CustomerNotFoundException;
import com.hd.cms.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    public Customer addCustomer(Customer customer) {

        return customerDAO.save(customer);
    }

    public List<Customer> getCustomerList() {

        return customerDAO.findAll();
    }

    public Customer getCustomerById(Long customerId) {

       /* return customerList
                .stream()
                .filter(customer -> customer.getCustomerId() == customerId)
                .findFirst()
                .get();*/
        Optional<Customer> optionalCustomer = customerDAO.findById(customerId);

        if (!optionalCustomer.isPresent())
            throw new CustomerNotFoundException("Customer not found with this id: " + customerId);

        return optionalCustomer.get();
    }

    public Customer updateCustomer(Long customerId, Customer customer) {
        /*customerList
                .stream()
                .forEach(c -> {
                    if ( c.getCustomerId() == customerId) {
                        c.setCustomerFirstName(customer.getCustomerFirstName());
                        c.setCustomerLastName(customer.getCustomerLastName());
                        c.setCustomerEmail(customer.getCustomerEmail());
                    }
                });*/
        customer.setCustomerId(customerId);

        return customerDAO.save(customer);
    }

    public void deleteCustomer(Long customerId) {
        customerDAO.deleteById(customerId);

    }


}
