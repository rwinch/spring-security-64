package org.example.springsecurity64;

import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountServiceTest {
	BankAccountService account = new BankAccountService();

	@AfterEach
	void cleanup() {
		SecurityContextHolder.clearContext();
	}

	@Test
	void findByIdGranted() {
		login("rob");
		this.account.findById(1);
	}

	@Test
	void findByIdDenied() {
		login("josh");
		assertThatExceptionOfType(AuthorizationDeniedException.class)
				.isThrownBy(() -> this.account.findById(1));
	}

	@Test
	void getByIdGranted() {
		login("rob");
		this.account.getById(1);
	}

	@Test
	void getByIdDenied() {
		login("josh");
		assertThatExceptionOfType(AuthorizationDeniedException.class)
				.isThrownBy(() -> this.account.getById(1));
	}

	void login(String username) {
		SecurityContextHolder.getContext()
				.setAuthentication(new TestingAuthenticationToken(username, "password", "ROLE_USER"));
	}
}
