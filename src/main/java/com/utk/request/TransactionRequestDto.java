package com.utk.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.io.Serializable;

public class TransactionRequestDto implements Serializable {
    private String upi_id;
    private String bank_name;
    private String transaction_date;
    private String currency;
    private String transaction_amount;
    private String transaction_details;

    public TransactionRequestDto() {
    }

    public TransactionRequestDto(String upi_id, String bank_name, String transaction_date, String currency, String transaction_amount, String transaction_details) {
        this.upi_id = upi_id;
        this.bank_name = bank_name;
        this.transaction_date = transaction_date;
        this.currency = currency;
        this.transaction_amount = transaction_amount;
        this.transaction_details = transaction_details;
    }

    public String getUpi_id() {
        return upi_id;
    }

    public void setUpi_id(String upi_id) {
        this.upi_id = upi_id;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(String transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public String getTransaction_details() {
        return transaction_details;
    }

    public void setTransaction_details(String transaction_details) {
        this.transaction_details = transaction_details;
    }

}