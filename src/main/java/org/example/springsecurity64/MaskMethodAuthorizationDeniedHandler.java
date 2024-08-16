package org.example.springsecurity64;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.authorization.AuthorizationResult;
import org.springframework.security.authorization.method.MethodAuthorizationDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class MaskMethodAuthorizationDeniedHandler implements MethodAuthorizationDeniedHandler {
	@Override
	public Object handleDeniedInvocation(MethodInvocation methodInvocation, AuthorizationResult authorizationResult) {
		return "****";
	}
}
