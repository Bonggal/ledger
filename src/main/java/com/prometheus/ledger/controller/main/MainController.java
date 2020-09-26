package com.prometheus.ledger.controller.main;

import com.prometheus.ledger.service.common.session.SessionService;
import com.prometheus.ledger.service.common.session.result.GetLoginSessionResult;
import com.prometheus.ledger.service.facade.member.MemberFacade;
import com.prometheus.ledger.service.facade.member.request.QueryMemberRequest;
import com.prometheus.ledger.service.facade.member.result.QueryMemberResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController implements ErrorController {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private MemberFacade memberFacade;

    @RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public String mainPage(HttpServletRequest request, HttpServletResponse response, Model model){
        GetLoginSessionResult result = sessionService.getLoginSession(request.getSession());
        model.addAttribute("userId", result.getUserId());

        QueryMemberRequest queryMemberRequest = new QueryMemberRequest();
        queryMemberRequest.setUserId(result.getUserId());
        QueryMemberResult queryMemberResult = memberFacade.queryMember(queryMemberRequest);
        model.addAttribute("username", queryMemberResult.getMember().getUsername());
        return "index";
    }

    @RequestMapping(value = {"/error"}, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String errorPage(HttpServletRequest request, HttpServletResponse response, Model model){
        return "error/error-404";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
