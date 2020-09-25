/**
 * DANA Indonesia.
 * Copyright (c) 2004‐2020 All Rights Reserved.
 */
package com.prometheus.ledger.service.impl.account.processor;

import com.prometheus.ledger.core.model.Processor;
import com.prometheus.ledger.core.model.error.ErrorCode;
import com.prometheus.ledger.core.util.AssertUtil;
import com.prometheus.ledger.repository.account.AccountRepository;
import com.prometheus.ledger.repository.account.entity.AccountDTO;
import com.prometheus.ledger.service.facade.account.request.CreateAccountRequest;
import com.prometheus.ledger.service.impl.account.context.BaseAccountContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author bonggal.siahaan
 * @version $Id: CreateAccountProcessor.java, v 0.1 2020‐09‐25 17.21 bonggal.siahaan Exp $$ */
public class CreateAccountProcessor implements Processor<BaseAccountContext> {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public boolean isSkipped(BaseAccountContext context) {
        return false;
    }

    @Override
    public void check(BaseAccountContext context) {

    }

    @Override
    public void doProcess(BaseAccountContext context) throws Exception {
        CreateAccountRequest createAccountRequest = (CreateAccountRequest) context.getRequest();
        AccountDTO accountDTOResult = accountRepository.save(generateAccountDTO(createAccountRequest));
        AssertUtil.isNotNull(accountDTOResult, ErrorCode.SYSTEM_ERROR, "Account creation failed");
    }

    private AccountDTO generateAccountDTO(CreateAccountRequest createAccountRequest){
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName(createAccountRequest.getAccountName());
        accountDTO.setAccountBalance(createAccountRequest.getAccountBalance());
        accountDTO.setAccountDesc(createAccountRequest.getAccountDesc());
        accountDTO.setCurrency(createAccountRequest.getCurrency());
        accountDTO.setUserId(""); // todo get current userId
        return accountDTO;
    }
}
