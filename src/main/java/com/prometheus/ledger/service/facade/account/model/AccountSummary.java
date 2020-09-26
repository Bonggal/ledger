package com.prometheus.ledger.service.facade.account.model;

import com.prometheus.ledger.core.model.BaseModel;
import com.prometheus.ledger.core.model.Money;

public class AccountSummary extends BaseModel {
    private String accountId;
    private String accountName;
    private Money accountBalance;
    private String accountDesc;

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
     * Getter method for property accountBalance.
     *
     * @return property value of accountBalance
     */
    public Money getAccountBalance() {
        return accountBalance;
    }

    /**
     * Setter method for property accountBalance.
     *
     * @param accountBalance value to be assigned to property accountBalance
     */
    public void setAccountBalance(Money accountBalance) {
        this.accountBalance = accountBalance;
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
}
