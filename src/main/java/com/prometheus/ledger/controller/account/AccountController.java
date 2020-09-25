package com.prometheus.ledger.controller.account;

import com.prometheus.ledger.core.model.EnvInfo;
import com.prometheus.ledger.core.util.StringUtil;
import com.prometheus.ledger.service.common.session.SessionService;
import com.prometheus.ledger.service.common.session.result.GetLoginSessionResult;
import com.prometheus.ledger.service.facade.account.AccountFacade;
import com.prometheus.ledger.service.facade.account.request.QueryAccountListRequest;
import com.prometheus.ledger.service.facade.account.result.QueryAccountListResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountFacade accountFacade;

    @Autowired
    private SessionService sessionService;

    private static final String ACCOUNTS = "accounts";

    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public String ledgerMainPage(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam Map<String, String> param) throws Throwable{
        GetLoginSessionResult loginSessionResult = sessionService.getLoginSession(request.getSession());
        if(StringUtil.isBlank(loginSessionResult.getUserId())){
            return "redirect:/login";
        }

        QueryAccountListRequest queryAccountListRequest = new QueryAccountListRequest();
        EnvInfo envInfo = new EnvInfo();
        envInfo.setUserId(loginSessionResult.getUserId());
        queryAccountListRequest.setEnvInfo(envInfo);
        QueryAccountListResult result = accountFacade.queryAccount(queryAccountListRequest);
        model.addAttribute(ACCOUNTS, result.toJsonObject());

        response.setStatus(HttpServletResponse.SC_OK);
        return "account/home";
    }
}
