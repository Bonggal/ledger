package com.prometheus.ledger.service.facade.account;

import com.prometheus.ledger.service.facade.account.request.CreateAccountRequest;
import com.prometheus.ledger.service.facade.account.request.QueryAccountListRequest;
import com.prometheus.ledger.service.facade.account.result.CreateAccountResult;
import com.prometheus.ledger.service.facade.account.result.QueryAccountListResult;

public interface AccountFacade {
    QueryAccountListResult queryAccount(QueryAccountListRequest request);
    CreateAccountResult createAccount(CreateAccountRequest request);
}
