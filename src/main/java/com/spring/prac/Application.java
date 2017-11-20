package com.spring.prac;

import com.spring.prac.model.Customer;
import com.spring.prac.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

    public static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }


    @Bean
    public CommandLineRunner test(CustomerRepository customerRepository){
        return (args)->{

            customerRepository.save(new Customer("firsr1","last1"));
            customerRepository.save(new Customer("firsr2","last2"));
            customerRepository.save(new Customer("firsr3","last3"));
            customerRepository.save(new Customer("firsr4","last4"));

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


            logger.info("fetch customer by last name and first name");
            List<Customer> customers= customerRepository.findByLastNameAndFirstName("last2","firsr2");
            customers.forEach(customer2 -> logger.info(customer2.toString()));


            logger.info("fetch customer by last name or first name");
             customers= customerRepository.findByLastNameOrFirstName("last2","firsr2");
            customers.forEach(customer2 -> logger.info(customer2.toString()));



        };
    }
}

