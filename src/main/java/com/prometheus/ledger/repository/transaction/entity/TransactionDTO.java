package com.prometheus.ledger.repository.transaction.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author bonggal.siahaan
 * @version $Id: TransactionDTO.java, v 0.1 2020‐09‐25 17.09 bonggal.siahaan Exp $$ */
@Entity
@Table(name = "prod_transaction")
public class TransactionDTO {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    @Column(name="trans_id")
    private String transactionId;

    @Column(name = "account_id")
    private String accountId;

    @Column(name = "trans_currency")
    private String transactionCurrency;

    @Column(name = "trans_amount")
    private double transactionAmount;

    @Column(name = "trans_notes")
    private String transactionNotes;

    @Column(name = "trans_category")
    private String transactionCategory;

    @Column(name = "trans_sub_category")
    private String transactionSubCategory;

    @Column(name = "trans_date")
    private long transactionDate;

    /**
     * Getter method for property transactionId.
     *
     * @return property value of transactionId
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Setter method for property transactionId.
     *
     * @param transactionId value to be assigned to property transactionId
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * Getter method for property accountId.
     *
     * @return property value of accountId
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Setter method for property accountId.
     *
     * @param accountId value to be assigned to property accountId
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * Getter method for property transactionCurrency.
     *
     * @return property value of transactionCurrency
     */
    public String getTransactionCurrency() {
        return transactionCurrency;
    }

    /**
     * Setter method for property transactionCurrency.
     *
     * @param transactionCurrency value to be assigned to property transactionCurrency
     */
    public void setTransactionCurrency(String transactionCurrency) {
        this.transactionCurrency = transactionCurrency;
    }

    /**
     * Getter method for property transactionAmount.
     *
     * @return property value of transactionAmount
     */
    public double getTransactionAmount() {
        return transactionAmount;
    }

    /**
     * Setter method for property transactionAmount.
     *
     * @param transactionAmount value to be assigned to property transactionAmount
     */
    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    /**
     * Getter method for property transactionNotes.
     *
     * @return property value of transactionNotes
     */
    public String getTransactionNotes() {
        return transactionNotes;
    }

    /**
     * Setter method for property transactionNotes.
     *
     * @param transactionNotes value to be assigned to property transactionNotes
     */
    public void setTransactionNotes(String transactionNotes) {
        this.transactionNotes = transactionNotes;
    }

    /**
     * Getter method for property transactionCategory.
     *
     * @return property value of transactionCategory
     */
    public String getTransactionCategory() {
        return transactionCategory;
    }

    /**
     * Setter method for property transactionCategory.
     *
     * @param transactionCategory value to be assigned to property transactionCategory
     */
    public void setTransactionCategory(String transactionCategory) {
        this.transactionCategory = transactionCategory;
    }

    /**
     * Getter method for property transactionSubCategory.
     *
     * @return property value of transactionSubCategory
     */
    public String getTransactionSubCategory() {
        return transactionSubCategory;
    }

    /**
     * Setter method for property transactionSubCategory.
     *
     * @param transactionSubCategory value to be assigned to property transactionSubCategory
     */
    public void setTransactionSubCategory(String transactionSubCategory) {
        this.transactionSubCategory = transactionSubCategory;
    }

    /**
     * Getter method for property transactionDate.
     *
     * @return property value of transactionDate
     */
    public long getTransactionDate() {
        return transactionDate;
    }

    /**
     * Setter method for property transactionDate.
     *
     * @param transactionDate value to be assigned to property transactionDate
     */
    public void setTransactionDate(long transactionDate) {
        this.transactionDate = transactionDate;
    }
}
