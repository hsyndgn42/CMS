package com.hd.cms.cms.dao;

import com.hd.cms.cms.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDAO extends CrudRepository<Customer,Long> {

    @Override
    List<Customer> findAll();
}
