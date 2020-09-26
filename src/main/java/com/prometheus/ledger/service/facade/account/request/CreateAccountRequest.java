/**
 * DANA Indonesia.
 * Copyright (c) 2004‐2020 All Rights Reserved.
 */
package com.prometheus.ledger.service.facade.account.request;

import com.prometheus.ledger.core.model.request.BaseRequest;

/**
 * @author bonggal.siahaan
 * @version $Id: CreateAccountRequest.java, v 0.1 2020‐09‐25 17.29 bonggal.siahaan Exp $$ */
public class CreateAccountRequest extends BaseRequest {
    private String accountName;
    private String accountDesc;
    private double accountBalance;
    private String currency;

    /**
     * Getter method for property accountName.
     *
     * @return property value of accountName
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Setter method for property accountName.
     *
     * @param accountName value to be assigned to property accountName
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * Getter method for property accountDesc.
     *
     * @return property value of accountDesc
     */
    public String getAccountDesc() {
        return accountDesc;
    }

    /**
     * Setter method for property accountDesc.
     *
     * @param accountDesc value to be assigned to property accountDesc
     */
    public void setAccountDesc(String accountDesc) {
        this.accountDesc = accountDesc;
    }

    /**
     * Getter method for property accountBalance.
     *
     * @return property value of accountBalance
     */
    public double getAccountBalance() {
        return accountBalance;
    }

    /**
     * Setter method for property accountBalance.
     *
     * @param accountBalance value to be assigned to property accountBalance
     */
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    /**
     * Getter method for property currency.
     *
     * @return property value of currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Setter method for property currency.
     *
     * @param currency value to be assigned to property currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
