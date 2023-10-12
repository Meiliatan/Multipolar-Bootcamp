package com.multipolar.bootcamp.kyc.service;

import com.multipolar.bootcamp.kyc.domain.Customer;
import com.multipolar.bootcamp.kyc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //Fungsi Get AllCust == kembalian berupa List
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    //Fungsi Get cust by id
    public Optional<Customer> getCustomerById(String id){
        return customerRepository.findById(id);
    }

    //Fungsi Create cust baru
    public Customer creatOrUpdateCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    //Fungsi Delete cust
    public void deleteCustomerById(String id){
        customerRepository.deleteById(id);
    }

    //find Cust by nik
    public Optional<Customer> getCustomerByNik(String nik){
        return customerRepository.findByNik(nik);
    }

    //findByFirstName
    public List<Customer> getCustomerByName(String firstName){
        return customerRepository.findByFirstNameInsensitive(firstName);
    }

}

