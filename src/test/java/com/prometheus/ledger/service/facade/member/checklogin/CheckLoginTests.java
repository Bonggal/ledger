/**
 * Alipay.com Inc.
 * Copyright (c) 2004‐2020 All Rights Reserved.
 */
package com.prometheus.ledger.service.facade.member.checklogin;

import com.prometheus.ledger.LedgerApplication;
import com.prometheus.ledger.LedgerApplicationTests;
import com.prometheus.ledger.core.util.JSONUtil;
import com.prometheus.ledger.core.util.StringUtil;
import com.prometheus.ledger.repository.account.AccountRepository;
import com.prometheus.ledger.repository.admin.AdminRepository;
import com.prometheus.ledger.repository.member.MemberRepository;
import com.prometheus.ledger.repository.member.entity.MemberDTO;
import com.prometheus.ledger.service.facade.member.MemberFacade;
import com.prometheus.ledger.service.facade.member.request.CheckLoginRequest;
import com.prometheus.ledger.service.facade.member.result.CheckLoginResult;
import com.prometheus.ledger.service.impl.member.MemberFacadeImpl;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;

/**
 * @author Bonggal Siahaan (bonggal.siahaan@dana.id)
 * @version $Id: CheckLoginTests.java, v 0.1 2020‐08‐14 17.03 bonggalsiahaan Exp $$ */
//@ExtendWith(MockitoExtension.class)
public class CheckLoginTests extends LedgerApplicationTests{

    @Autowired
    private MemberFacade memberFacade;

    @Before
    @Autowired
    public void setUp(){
        super.setUp();
    }

    @Test
    public void test001(){
        Assert.assertTrue(true);
    }

    @Test
    public void restTest() throws Exception{
//        Mockito.when(memberRepository.findByUsernameAndPassword(Mockito.anyString(), Mockito.anyString()))
//                .thenReturn("");
        doReturn(getMemberListSuccess())
                .when(memberRepository)
                .findByUsernameAndPassword(Mockito.anyString(), Mockito.anyString());

        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("username", "username");
        bodyMap.put("password", "password");
        bodyMap.put("submit", "Sign In");
        String requestBody = JSONUtil.toJsonString(bodyMap);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .accept(MediaType.APPLICATION_JSON_VALUE).content(requestBody))
                .andReturn();
        System.out.println(">>>result: "+JSONUtil.toJsonObject(mvcResult.getResponse()));
    }

    @Test
    public void checkLogin_success(){
        CheckLoginRequest request = new CheckLoginRequest();
        request.setUsername("TestUserName");
        request.setPassword("TestPassword");

        doReturn(getMemberListSuccess())
                .when(memberRepository)
                .findByUsernameAndPassword(Mockito.anyString(), Mockito.anyString());
        CheckLoginResult result = memberFacade.checkLogin(request);

        Assert.assertNotNull(result);
        Assert.assertTrue(result.isSuccess());
        Assert.assertTrue(StringUtil.isNotBlank(result.getUserId()));
        Assert.assertTrue(result.isExist());
    }

    private static List<MemberDTO> getMemberListSuccess(){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setEmail("email");
        memberDTO.setPassword("password");
        memberDTO.setUsername("username");
        memberDTO.setMemberId("memberId");
        memberDTO.setPhonenumber("phoneNumber");
        List<MemberDTO> memberDTOList = new ArrayList<>();
        memberDTOList.add(memberDTO);
        return new ArrayList<>();
    }
}