package com.spring.prac.scheduler;

import com.spring.prac.Application;
import com.spring.prac.entity.Customer;
import com.spring.prac.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustScheduler {

    public static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    CustomerRepository customerRepository;

    @Scheduled(cron = "${db.schedule}")
    public void dbSchedule(){

        //fetch all customer
        logger.info("fetch all customer");
        customerRepository.findAll().forEach(customer -> logger.info(customer.toString()));

        logger.info("fetch customer by id");
        Customer customer = customerRepository.findOne(1L);
        logger.info(customer.toString());
        logger.info(" ");


        logger.info("fetch customer by last name");
        List<Customer> customerList= customerRepository.findByLastName("last2");
        customerList.forEach(customer1 -> logger.info(customer1.toString()));

    }

}
