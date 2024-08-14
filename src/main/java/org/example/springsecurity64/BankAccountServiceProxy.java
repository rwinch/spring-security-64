package org.example.springsecurity64;

import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.Principal;

public class BankAccountServiceProxy extends BankAccountService {

	@Override
	public BankAccount findById(int id) {
		BankAccount result = super.findById(id);
		Principal user = SecurityContextHolder.getContext().getAuthentication();
		if (!user.getName().equals(result.getOwner())) {
			throw new AuthorizationDeniedException("Denied", new AuthorizationDecision(false));
		}
		return result;
	}

	@Override
	public BankAccount getById(int id) {
		return super.getById(id);
	}
}
