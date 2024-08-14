package org.example.springsecurity64;

import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.Principal;

public class BankAccountService {
	public BankAccount findById(int id) {
		BankAccount result = new BankAccount(id, "rob", "1234", 54321);

		return result;
	}

	public BankAccount getById(int id) {
		return findById(id);
	}

}
