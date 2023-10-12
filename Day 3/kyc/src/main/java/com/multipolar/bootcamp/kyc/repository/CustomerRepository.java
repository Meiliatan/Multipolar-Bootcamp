package com.multipolar.bootcamp.kyc.repository;

import com.multipolar.bootcamp.kyc.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    Optional<Customer> findByNik(String nik);

    Optional<Customer> findByFirstName(String firstName);

    @Query("{ 'firstName' : { $regex: ?0, $options: 'i' } }")
    List<Customer> findByFirstNameInsensitive(String firstName);


}
