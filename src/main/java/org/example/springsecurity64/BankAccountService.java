package org.example.springsecurity64;

import org.springframework.security.access.prepost.PreAuthorize;

public interface BankAccountService {
	@PostReadBankAccount
	BankAccount findById(int id);

	@PostReadBankAccount
	BankAccount getById(int id);

	@PreWriteBankAccount("#toSave")
	void save(BankAccount toSave);


	@PreWriteBankAccount("#toUpdate")
	void update(BankAccount toUpdate);
}
