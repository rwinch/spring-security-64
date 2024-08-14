package org.example.springsecurity64;

public class BankAccount {
	final int id;
	final String owner;
	final String accountNumber;
	final double balance;

	public BankAccount(int id, String owner, String accountNumber, double balance) {
		this.id = id;
		this.owner = owner;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public String getOwner() {
		return owner;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}
}
