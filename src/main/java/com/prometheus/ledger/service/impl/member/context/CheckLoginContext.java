package com.prometheus.ledger.service.impl.member.context;

import com.prometheus.ledger.core.model.BaseProcessContext;
import com.prometheus.ledger.core.model.request.BaseRequest;
import com.prometheus.ledger.core.model.result.BaseResult;

public class CheckLoginContext extends BaseProcessContext {
    public CheckLoginContext(BaseRequest request, BaseResult result) {
        super(request, result);
    }
}
