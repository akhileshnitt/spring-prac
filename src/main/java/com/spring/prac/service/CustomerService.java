package com.spring.prac.service;


import com.spring.prac.entity.Customer;
import com.spring.prac.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("customerService")
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;



    public List<com.spring.prac.model.Customer> fetchAllCustomer(){
        List<Customer> customers=  customerRepository.findAll();
        List<com.spring.prac.model.Customer> modelCustomer = new ArrayList<>();
        for(Customer customer:customers){
            modelCustomer.add(new com.spring.prac.model.Customer(customer.getId(),customer.getFirstName(),customer.getLastName()));
        }
        return  modelCustomer;

    }

    public com.spring.prac.model.Customer findCustomer(String id) {

       Customer customer = customerRepository.findOne(Long.valueOf(id));
       return new com.spring.prac.model.Customer(customer.getId(),customer.getFirstName(),customer.getLastName());
    }
}
