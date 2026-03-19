package com.practise.banking.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.practise.banking.Enum.AccountType;
import com.practise.banking.Enum.AccuontStatus;
import com.practise.banking.Enum.Currency;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(schema = "banking",name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private long accountId;

    private long accountNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customerId;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private double balance;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Enumerated(EnumType.STRING)
    private AccuontStatus status;

    private Date createdDate;
    private Date lastupdatedDate;

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public AccuontStatus getStatus() {
        return status;
    }

    public void setStatus(AccuontStatus status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getlastupdatedDate() {
        return lastupdatedDate;
    }

    public void setlastupdatedDate(Date lastupdatedDate) {
        this.lastupdatedDate = lastupdatedDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountNumber=" + accountNumber +
                ", customerId=" + customerId +
                ", accountType=" + accountType +
                ", balance=" + balance +
                ", currency=" + currency +
                ", status=" + status +
                ", createdDate=" + createdDate +
                ", lastupdatedDate=" + lastupdatedDate +
                '}';
    }
}
