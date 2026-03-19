package com.practise.banking.Service;

import com.practise.banking.DTO.Account;
import com.practise.banking.DTO.Customer;
import com.practise.banking.Repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountService {

    private final Logger log = LoggerFactory.getLogger(AccountService.class);

    private AccountRepository repo;

    private WebClient webClient;

    @Autowired
    public AccountService(AccountRepository accountRepository, WebClient webClient) {
        this.webClient = webClient;
        this.repo = repo;
    }

    public Account createacc(Account account) {
        log.info("Creating account for customer id: {}", account.getCustomerId());

        Account a = new Account();
        if(account != null){
            a = account;
            repo.save(a);
            return a;
        }
        else{
            log.error("Account is null");
            throw new IllegalArgumentException("Account cannot be null");
        }

    }

    public Account getaccbyid(long id) {
        log.info("Getting account by id: {}", id);
        Account a = repo.findById(id).orElse(null);
        if(a == null){
            log.error("Account not found");
            throw new IllegalArgumentException("Account not found");
        }
        else{
            return a;
        }
    }

    public Map<Long, List<Account>> getaccbycust(long id) {
        log.info("Getting account by customer id: {}", id);
        Map<Long, List<Account>> m = new HashMap<>();

        Customer c = getcustomer(id).block();

            List<Account> a = c.getAccount();

            m.put(id, a);

            return m;
    }

    public Mono<Customer> getcustomer(long id){
        return webClient.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(Customer.class);
    }
}
