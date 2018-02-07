package com.notification.service.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "transaction")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = Transaction.class)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_transaction")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long idTransaction;

    @Column(name = "transaction_code", length = 5, unique = true)
    @NotNull
    private Integer transactionCode;

    @NotNull
    @Column(name = "date" , length = 6)
    private String date;

    @NotNull
    @Column(name = "account_number", length = 23)
    private String accountNumber;

    @Column(name = "amount" , length = 13)
    @NotNull
    private Integer amount;

    @Column(name = "currency" , length = 3)
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private CurrencyType currencyType;

    @Column(name = "recipient" , length = 23)
    private String recipient;

    @Column(name = "branch_office_code" , length = 5)
    @NotNull
    private String branchOfficeCode;

    @Column(name = "transaction_detail" , length = 40)
    @NotNull
    private String transactionDetail;

    @Column(name = "cashier_id" , length = 8)
    private String cashierId;

    @Column(name = "account_balance" , length = 13)
    private long accountBalance;

    @Column(name = "check_number" , length = 11)
    private int checkNumber;

    @Column(name = "code_SCA" , length = 1)
    private String codeSCA;

    @Column(name = "date_SCA" , length = 8)
    private String dateSCA;

    @Column(name = "hour" , length = 7)
    @NotNull
    private Integer hour;

    public Integer getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(Integer transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }


    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getBranchOfficeCode() {
        return branchOfficeCode;
    }

    public void setBranchOfficeCode(String branchOfficeCode) {
        this.branchOfficeCode = branchOfficeCode;
    }

    public String getTransactionDetail() {
        return transactionDetail;
    }

    public void setTransactionDetail(String transactionDetail) {
        this.transactionDetail = transactionDetail;
    }

    public String getCashierId() {
        return cashierId;
    }

    public void setCashierId(String cashierId) {
        this.cashierId = cashierId;
    }

    public long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(long accountBalance) {
        this.accountBalance = accountBalance;
    }

    public int getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(int checkNumber) {
        this.checkNumber = checkNumber;
    }

    public String getCodeSCA() {
        return codeSCA;
    }

    public void setCodeSCA(String codeSCA) {
        this.codeSCA = codeSCA;
    }

    public String getDateSCA() {
        return dateSCA;
    }

    public void setDateSCA(String dateSCA) {
        this.dateSCA = dateSCA;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }
}