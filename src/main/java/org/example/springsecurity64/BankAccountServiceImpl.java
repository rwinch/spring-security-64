package org.example.springsecurity64;

import org.springframework.security.authorization.AuthorizationProxyFactory;
import org.springframework.security.authorization.method.AuthorizationAdvisorProxyFactory;

public class BankAccountServiceImpl implements BankAccountService {
	@Override
	public BankAccount findById(int id) {
		BankAccount result = new BankAccount(id, "rob", "1234", 54321);
		AuthorizationProxyFactory factory = AuthorizationAdvisorProxyFactory.withDefaults();
		return (BankAccount) factory.proxy(result);
	}

	@Override
	public BankAccount getById(int id) {
		return findById(id);
	}

}
