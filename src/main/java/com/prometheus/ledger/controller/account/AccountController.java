package com.prometheus.ledger.controller.account;

import com.prometheus.ledger.core.model.EnvInfo;
import com.prometheus.ledger.core.util.StringUtil;
import com.prometheus.ledger.service.common.session.SessionService;
import com.prometheus.ledger.service.common.session.result.GetLoginSessionResult;
import com.prometheus.ledger.service.facade.account.AccountFacade;
import com.prometheus.ledger.service.facade.account.request.CreateAccountRequest;
import com.prometheus.ledger.service.facade.account.request.QueryAccountListRequest;
import com.prometheus.ledger.service.facade.account.result.CreateAccountResult;
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

    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    public String getCreateAccountPage(HttpServletRequest request, HttpServletResponse response, Model model) throws Throwable{
        GetLoginSessionResult loginSessionResult = sessionService.getLoginSession(request.getSession());
        if(StringUtil.isBlank(loginSessionResult.getUserId())){
            return "redirect:/login";
        }
        return "account/create";
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.POST)
    public String createAccount(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam Map<String, String> param) throws Throwable{
        GetLoginSessionResult loginSessionResult = sessionService.getLoginSession(request.getSession());
        if(StringUtil.isBlank(loginSessionResult.getUserId())){
            return "redirect:/login";
        }

        double accountBalance = 0;
        try {
            accountBalance = Double.parseDouble(param.get("accountBalance"));
        } catch (Throwable e){
            e.printStackTrace();
        }

        CreateAccountRequest createAccountRequest = new CreateAccountRequest();
        createAccountRequest.setAccountName(param.get("accountName"));
        createAccountRequest.setAccountDesc(param.get("accountDesc"));
        createAccountRequest.setAccountBalance(accountBalance);
        createAccountRequest.setCurrency(param.get("accountCurrency"));
        EnvInfo envInfo = new EnvInfo();
        envInfo.setUserId(loginSessionResult.getUserId());
        createAccountRequest.setEnvInfo(envInfo);
        CreateAccountResult createAccountResult = accountFacade.createAccount(createAccountRequest);
        System.out.println("Account creation result: "+createAccountResult.isSuccess());
        return "account/create";
    }
}
