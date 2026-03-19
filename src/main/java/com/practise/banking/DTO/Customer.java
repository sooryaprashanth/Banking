package com.practise.banking.DTO;

import com.practise.banking.Enum.CustomerStatus;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.jspecify.annotations.NonNull;

import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "banking", name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long customerId;

    @Nonnull
    private String firstname;
    private String lastname;
    private Date dateofbirth;
    private String email;
    private long phonenumber;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "Street", column = @Column(name = "street")),
            @AttributeOverride(name = "City", column = @Column(name = "city")),
            @AttributeOverride(name = "State", column = @Column(name = "state")),
            @AttributeOverride(name = "postalcode", column = @Column(name = "postalcode"))
    })
    private Address address;

    private Date createdAt;

    @Enumerated(EnumType.STRING)
    private CustomerStatus status;

    @OneToMany(mappedBy = "customerId",cascade = CascadeType.ALL)
    private List<Account> account;

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(@NonNull String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dateofbirth='" + dateofbirth + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber=" + phonenumber +
                ", address=" + address +
                ", createdAt=" + createdAt +
                ", status=" + status +
                ", account=" + account +
                '}';
    }
}
