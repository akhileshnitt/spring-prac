package com.spring.prac.repository;

import com.spring.prac.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
    List<Customer> findByLastName(String lastName);


    @Query("select c from Customer c where c.lastName  = ?1 and c.firstName = ?2")
    List<Customer> findByLastNameAndFirstName(String lastName,String firstName);




    @Query("select c from Customer c where c.lastName  = ?1 OR c.firstName = ?2")
    List<Customer> findByLastNameOrFirstName(String lastName,String firstName);


}
