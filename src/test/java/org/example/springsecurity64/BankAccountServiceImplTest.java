package org.example.springsecurity64;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.authorization.AuthorizationProxyFactory;
import org.springframework.security.authorization.method.AuthorizationAdvisorProxyFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class BankAccountServiceImplTest {
	AuthorizationProxyFactory proxyFactory = AuthorizationAdvisorProxyFactory.withDefaults();
	BankAccountService account = (BankAccountService) proxyFactory.proxy(new BankAccountServiceImpl());

	@Test
	@WithMockRob
	void findByIdGranted() {
		this.account.findById(1);
	}

	@Test
	@WithMockJosh
	void findByIdDenied() {
		assertThatExceptionOfType(AuthorizationDeniedException.class)
				.isThrownBy(() -> this.account.findById(1));
	}

	@Test
	@WithMockRob
	void getByIdGranted() {
		this.account.getById(1);
	}

	@Test
	@WithMockJosh
	void getByIdDenied() {
		assertThatExceptionOfType(AuthorizationDeniedException.class)
				.isThrownBy(() -> this.account.getById(1));
	}
}
