/**
 * DANA Indonesia.
 * Copyright (c) 2004‐2020 All Rights Reserved.
 */
package com.prometheus.ledger.service.impl.account.processor;

import com.prometheus.ledger.core.model.Processor;
import com.prometheus.ledger.service.impl.account.context.BaseAccountContext;

/**
 * @author bonggal.siahaan
 * @version $Id: CreateAccountProcessor.java, v 0.1 2020‐09‐25 17.21 bonggal.siahaan Exp $$ */
public class CreateAccountProcessor implements Processor<BaseAccountContext> {
    @Override
    public boolean isSkipped(BaseAccountContext context) {
        return false;
    }

    @Override
    public void check(BaseAccountContext context) {

    }

    @Override
    public void doProcess(BaseAccountContext context) throws Exception {

    }
}
