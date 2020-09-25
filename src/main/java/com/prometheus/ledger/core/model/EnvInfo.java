/**
 * DANA Indonesia.
 * Copyright (c) 2004‐2020 All Rights Reserved.
 */
package com.prometheus.ledger.core.model;

/**
 * @author bonggal.siahaan
 * @version $Id: EnvInfo.java, v 0.1 2020‐09‐25 21.56 bonggal.siahaan Exp $$ */
public class EnvInfo extends BaseModel{
    private String userId;

    /**
     * Getter method for property userId.
     *
     * @return property value of userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Setter method for property userId.
     *
     * @param userId value to be assigned to property userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
