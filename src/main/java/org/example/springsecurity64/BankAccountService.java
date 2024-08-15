package org.example.springsecurity64;

import org.springframework.security.access.prepost.PostAuthorize;

public interface BankAccountService {
	@PostAuthorize("returnObject?.owner == authentication?.name")
	BankAccount findById(int id);

	@PostAuthorize("returnObject?.owner == authentication?.name")
	BankAccount getById(int id);
}
