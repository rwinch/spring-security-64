package org.example.springsecurity64;

public class BankAccountServiceImpl implements BankAccountService {
	@Override
	public BankAccount findById(int id) {
		BankAccount result = new BankAccount(id, "rob", "1234", 54321);

		return result;
	}

	@Override
	public BankAccount getById(int id) {
		return findById(id);
	}

}
