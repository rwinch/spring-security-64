package org.example.springsecurity64;

import org.springframework.security.access.prepost.PreAuthorize;

public interface BankAccountService {
	@PostReadBankAccount
	BankAccount findById(int id);

	@PostReadBankAccount
	BankAccount getById(int id);

	@PreAuthorize("#toSave?.owner == authentication?.name")
	void save(BankAccount toSave);

	@PreAuthorize("#toUpdate?.owner == authentication?.name")
	void update(BankAccount toUpdate);
}
