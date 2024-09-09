package com.Regina.SpringBootMongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Regina.SpringBootMongoDB.domain.User;


@Repository
public interface UserRepository  extends MongoRepository<User,String>{

}
