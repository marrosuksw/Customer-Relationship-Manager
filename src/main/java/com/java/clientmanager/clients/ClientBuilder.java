package com.java.clientmanager.clients;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

public class ClientBuilder {
    private Long id;
    private String companyName;
    private String ownerName;
    private String ownerSurname;
    private String phoneNumber;
    private String emailAddress;
    private LocalDate creationDate;
    private BigDecimal estimatedValue;

    private ClientBuilder() {}


    public static ClientBuilder builder() {
        return new ClientBuilder();
    }
    public ClientBuilder withId(Long id){
        this.id = id;
        return this;
    }

    public ClientBuilder withCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public ClientBuilder withOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    public ClientBuilder withOwnerSurname(String ownerSurname) {
        this.ownerSurname = ownerSurname;
        return this;
    }

    public ClientBuilder withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public ClientBuilder withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public ClientBuilder withEstimatedValue(BigDecimal estimatedValue) {
        this.estimatedValue = estimatedValue;
        return this;
    }

    public ClientBuilder withCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        return this;
    }
    
    public Client build() {
        return new Client (companyName,
        ownerName,
        ownerSurname,
        phoneNumber,
        emailAddress,
        creationDate,
        estimatedValue);
    }


}
