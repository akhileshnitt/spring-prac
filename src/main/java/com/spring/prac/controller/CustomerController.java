package com.spring.prac.controller;


import com.spring.prac.model.Customer;
import com.spring.prac.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {


    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;


    @GetMapping("/customers")
    public List<Customer> allCustomer(){
        logger.info("inside CustomerController");

     //   System.out.println();
        return  customerService.fetchAllCustomer();
    }


    @GetMapping("/customers/{id}")
    public Customer allCustomer(@PathVariable("id") String id){
       // logger.info("inside CustomerController");

        //   System.out.println();
        return  customerService.findCustomer(id);
    }


    @GetMapping("/")
    public String testPage(){
        return  "Test Page";
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "login";
    }

}
