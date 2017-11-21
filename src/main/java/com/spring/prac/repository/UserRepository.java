package com.spring.prac.repository;

import com.spring.prac.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long>{


}
