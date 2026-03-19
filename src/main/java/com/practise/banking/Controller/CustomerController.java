package com.practise.banking.Controller;

import com.practise.banking.DTO.Customer;
import com.practise.banking.Service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final Logger log = LoggerFactory.getLogger(CustomerController.class);

    private CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> createCustomer(@Validated @RequestBody Customer customer) {
        log.info("Into Customer Creation Method");
        try{
            Customer c = service.createcustomer(customer);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("{/id}").buildAndExpand(c.getCustomerId()).toUri();
            return ResponseEntity.created(uri).body(c);
        }
        catch(Exception ex){
            log.error("Error while creating customer: {}", ex.getMessage());
            return ResponseEntity.status(500).build();
        }
        finally {
            log.info("Exiting Customer Creation Method");
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable long id){
        try{
            Customer c = service.getcustomer(id);
            return ResponseEntity.ok().body(c);
        } catch (Exception e) {
            throw new IllegalArgumentException("Customer not found with id: " + id);
        }
    }
}
