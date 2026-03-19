package com.practise.banking.Controller;

import com.practise.banking.DTO.Account;
import com.practise.banking.Service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/account")
public class AccountController {

    private final Logger log = LoggerFactory.getLogger(AccountController.class);

    private AccountService service;

    @Autowired
    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping("/addAccount")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        log.info("Into Account Creation Method");
        try{
            Account a = service.createacc(account);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("{/id}").buildAndExpand(a.getAccountId()).toUri();
            return ResponseEntity.created(uri).body(a);
        }
        catch(Exception ex){
            log.error("Exception Occurred while trying to create account ", ex);
            throw new RuntimeException("Error while creating account: " + ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccById(@PathVariable long id){
        log.info("Into Account Get Method");
        try{
            Account a = service.getaccbyid(id);
            return ResponseEntity.ok().body(a);
        }
        catch(Exception ex){
            log.error("Customer is null");
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Map<Long, List<Account>>> getaccbycust(@PathVariable long id){
        log.info("Into Account Get by Customer Method");
        try{
            Map<Long, List<Account>> accs = service.getaccbycust(id);
            return ResponseEntity.ok().body(accs);
        }
        catch(Exception ex){
            log.error("CustomerId and Account is Not Available");
            return ResponseEntity.badRequest().build();
        }
    }
}
