package com.practise.banking.Service;

import com.practise.banking.DTO.Customer;
import com.practise.banking.Repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final Logger log = LoggerFactory.getLogger(CustomerService.class);

    private CustomerRepository repo;

    @Autowired
    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public Customer createcustomer(Customer customer) {
        log.info("Creating customer :{}", customer.getFirstname());
        Customer c = new Customer();
        if(customer != null){
            c = customer;
            repo.save(c);
            return c;
        }
        else {
            log.error("Customer is null");
            throw new IllegalArgumentException("Customer cannot be null");
        }
    }

    public Customer getcustomer(long id) {
        log.info("Getting customer by id: {}", id);
            Customer c = repo.findById(id).orElse(null);
            if(c == null){
                log.error("Customer not found");
                throw new IllegalArgumentException("Customer not found");
            }
            else{
                return c;
            }
    }
}
