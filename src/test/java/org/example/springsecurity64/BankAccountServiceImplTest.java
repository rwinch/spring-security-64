package org.example.springsecurity64;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class BankAccountServiceImplTest {
	BankAccountService account = new BankAccountServiceProxy(new BankAccountServiceImpl());

	@Test
	@WithMockUser("rob")
	void findByIdGranted() {
		this.account.findById(1);
	}

	@Test
	@WithMockUser("josh")
	void findByIdDenied() {
		assertThatExceptionOfType(AuthorizationDeniedException.class)
				.isThrownBy(() -> this.account.findById(1));
	}

	@Test
	@WithMockUser("rob")
	void getByIdGranted() {
		this.account.getById(1);
	}

	@Test
	@WithMockUser("josh")
	void getByIdDenied() {
		assertThatExceptionOfType(AuthorizationDeniedException.class)
				.isThrownBy(() -> this.account.getById(1));
	}
}
