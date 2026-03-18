package com.practise.banking.DTO;

import com.practise.banking.Enum.AccountType;
import com.practise.banking.Enum.AccuontStatus;
import com.practise.banking.Enum.Currency;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private UUID accountId;

    private long accountNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;

    private AccountType accountType;
    private double balance;
    private Currency currency;
    private AccuontStatus status;

    private Date createdDate;
    private Date lastUpdatedDate;

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
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

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
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
                ", lastUpdatedDate=" + lastUpdatedDate +
                '}';
    }
}
