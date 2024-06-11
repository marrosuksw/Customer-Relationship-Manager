package com.java.clientmanager.clients;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

import java.time.LocalDate;
import java.math.BigDecimal;

// implement builder

// check lombok
// @Entity, integracja H2 DB
// @Component, interfejsy
// ^ odwrócenie zależności i wstrzykiwanie zależności
// SpringData JPA, wzorzec repository
// Amigos code
@Entity
public  class Client {
    @Id
    @GeneratedValue
    private Long id;
    private String companyName;
    private String ownerName;
    private String ownerSurname;
    private String phoneNumber;
    private String emailAddress;
    private LocalDate creationDate; //remember to init in function
    private BigDecimal estimatedValue; // remember to init in function
    /*
     private variables - collecting Client data
     Data: company name, client name, surname, firm address(opt), contact information, created(date)
     Estimated value, stage/label (?)


     create client (requirement: add client name)
     delete client - removes client - button interaction + confirmation (?)
    */
    public Client(){}

    public Client(String compName){
        companyName = compName;
//        setCreationDate(creationDate.now());
    }

    public Client(String companyName, String ownerName, String ownerSurname, String phoneNumber, String emailAddress, LocalDate creationDate, String note, BigDecimal estimatedValue) {
        this.companyName = companyName;
        this.ownerName = ownerName;
        this.ownerSurname = ownerSurname;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.creationDate = creationDate;
        this.estimatedValue = estimatedValue;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerSurname() {
        return ownerSurname;
    }

    public void setOwnerSurname(String ownerSurname) {
        this.ownerSurname = ownerSurname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public BigDecimal getEstimatedValue() {
        return estimatedValue;
    }

    public void setEstimatedValue(BigDecimal estimatedValue) {
        this.estimatedValue = estimatedValue;
    }

    public Long getId() {
        return id;
    }


}
