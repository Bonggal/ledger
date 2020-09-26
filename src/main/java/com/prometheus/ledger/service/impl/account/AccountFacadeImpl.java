package com.prometheus.ledger.service.impl.account;

import com.prometheus.ledger.core.model.BaseProcessContext;
import com.prometheus.ledger.core.model.Processor;
import com.prometheus.ledger.core.util.ProcessorUtil;
import com.prometheus.ledger.service.facade.account.AccountFacade;
import com.prometheus.ledger.service.facade.account.request.CreateAccountRequest;
import com.prometheus.ledger.service.facade.account.request.QueryAccountListRequest;
import com.prometheus.ledger.service.facade.account.result.CreateAccountResult;
import com.prometheus.ledger.service.facade.account.result.QueryAccountListResult;
import com.prometheus.ledger.service.impl.account.context.BaseAccountContext;

import java.util.List;

public class AccountFacadeImpl implements AccountFacade {

    private static List<Processor<BaseProcessContext>> queryAccountListProcessors;
    private static List<Processor<BaseProcessContext>> createAccountProcessors;

    @Override
    public QueryAccountListResult queryAccount(QueryAccountListRequest request) {
        QueryAccountListResult result = new QueryAccountListResult();
        BaseAccountContext context = new BaseAccountContext(request, result);
        ProcessorUtil.runProcessors(queryAccountListProcessors, context);
        return result;
    }

    @Override
    public CreateAccountResult createAccount(CreateAccountRequest request) {
        CreateAccountResult result = new CreateAccountResult();
        BaseAccountContext context = new BaseAccountContext(request, result);
        ProcessorUtil.runProcessors(createAccountProcessors, context);
        return result;
    }


    public static void setQueryAccountListProcessors(List<Processor<BaseProcessContext>> queryAccountListProcessors) {
        AccountFacadeImpl.queryAccountListProcessors = queryAccountListProcessors;
    }

    /**
     * Setter method for property createAccountProcessors.
     *
     * @param createAccountProcessors value to be assigned to property createAccountProcessors
     */
    public static void setCreateAccountProcessors(List<Processor<BaseProcessContext>> createAccountProcessors) {
        AccountFacadeImpl.createAccountProcessors = createAccountProcessors;
    }
}
