package org.example.springsecurity64;

public interface BankAccountService {
	@PostReadBankAccount
	BankAccount findById(int id);

	@PostReadBankAccount
	BankAccount getById(int id);
}
