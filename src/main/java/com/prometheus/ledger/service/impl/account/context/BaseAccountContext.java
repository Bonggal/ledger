package com.prometheus.ledger.service.impl.account.context;

import com.prometheus.ledger.core.model.BaseProcessContext;
import com.prometheus.ledger.core.model.request.BaseRequest;
import com.prometheus.ledger.core.model.result.BaseResult;

public class BaseAccountContext extends BaseProcessContext {
    public BaseAccountContext(BaseRequest request, BaseResult result) {
        super(request, result);
    }
}
