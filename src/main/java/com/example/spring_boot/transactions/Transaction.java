package com.example.spring_boot.transactions;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Transaction {
    @Id
    @GeneratedValue private Long id;
    private String service;
    private Double amount;

    protected Transaction() {}

    public Transaction(String service, Double amount){
        this.service = service;
        this.amount = amount;
    }

    public Long getId() {
        return this.id;
    }

    public String getService() {
        return this.service;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public  void setService(String service){
        this.service = service;
    }

    public void setAmount(Double amount){
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "{" + "id=" + this.id + ", service='" + this.service + '\'' + ", amount='" + this.amount + '\'' + '}';
    }
}
