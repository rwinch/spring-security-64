package org.example.springsecurity64;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authorization.AuthorizationDeniedException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class BankAccountServiceImplTest {
	@Autowired
	BankAccountService account;

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

	@Test
	@WithMockAccountant
	void getByIdWhenAccountantGranted() {
		this.account.getById(1);
	}

	@Test
	@WithMockAccountant
	void getAccountNumberWhenAccountantDenied() {
		BankAccount account = this.account.getById(1);
		assertThatExceptionOfType(AuthorizationDeniedException.class)
				.isThrownBy(() -> account.getAccountNumber());
	}
}
