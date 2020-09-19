package com.prometheus.ledger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prometheus.ledger.controller.login.LoginController;
import com.prometheus.ledger.repository.account.AccountRepository;
import com.prometheus.ledger.repository.admin.AdminRepository;
import com.prometheus.ledger.repository.member.MemberRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = LoginController.class)
public abstract class LedgerApplicationTests {

	@Autowired
	protected MockMvc mockMvc;

	@MockBean
	protected MemberRepository memberRepository;
	@MockBean
	protected AccountRepository accountRepository;
	@MockBean
	protected AdminRepository adminRepository;

	protected void setUp() {
	}

	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	protected <T> T mapFromJson(String json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}

}
