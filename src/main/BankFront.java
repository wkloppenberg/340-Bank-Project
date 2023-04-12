/* 
 * William Kloppenberg
 * william.kloppenberg@mymail.champlain.edu
 * Final Project
 * 
 */

package main;

import java.util.ArrayList;
import java.util.List;

import bank.BankAccount;

public class BankFront {
	
	bank.BankAccount checking;
	bank.BankAccount savings;
	
	public BankFront() {
	}
	
	
	public void newAccount(String type, String name) {
		if (type.equals("C")) {
			if (checking != null) {
				System.err.println("Checking account already exists.");
			}
			else {
				checking = new bank.CheckingAccount(name);
			}
		}
		else if (type.equals("S")) {
			if (savings != null) {
				System.err.println("Savings account already exists.");
			}
			else {
				savings = new bank.SavingsAccount(name);
			}
		}
		else {
			System.err.println("Invalid input.");
		}
	}
	
	public void deposit(String type, double amount) {
		if (type.equals("C")) {
			if (checking != null) {
				checking.deposit(amount);
			}
			else {
				System.err.println("Checking account does not exist.");
			}
		}
		else if (type.equals("S")) {
			if (savings != null) {
				savings.deposit(amount);
			}
			else {
				System.err.println("Savings account does not exist.");
			}
		}
		else {
			System.err.println("Invalid input.");
		}
	}
	
	public void withdraw(String type, double amount) {
		if (type.equals("C")) {
			if (checking != null) {
				checking.withdraw(amount);
			}
			else {
				System.err.println("Checking account does not exist.");
			}
		}
		else if (type.equals("S")) {
			if (savings != null) {
				savings.withdraw(amount);
			}
			else {
				System.err.println("Savings account does not exist.");
			}
		}
		else {
			System.err.println("Invalid input.");
		}
	}
	
	public void display(String type) {
		if (type.equals("C")) {
			if (checking != null) {
				System.out.print("\n");
				System.out.println("CHECKING ACCOUNT INFORMATION");
				System.out.println("Name: " + checking.getAccountName());
				System.out.println("Balance: " + checking.getBalance());
			}
			else {
				System.err.println("Checking account does not exist.");
			}
		}
		else if (type.equals("S")) {
			if (savings != null) {
				System.out.print("\n");
				System.out.println("SAVINGS ACCOUNT INFORMATION");
				System.out.println("Name: " + savings.getAccountName());
				System.out.println("Balance: " + savings.getBalance());
			}
			else {
				System.err.println("Savings account does not exist.");
			}
		}
		else {
			System.err.println("Invalid input.");
		}
		System.out.print("\n");
	}


	public void transferFromCheckingToSavings(double amount) {
		// TODO Auto-generated method stub
		
	}


	public void transferFromSavingsToChecking(double amount) {
		// TODO Auto-generated method stub
		
	}


	public void transferToOtherAccount(String string, BankFront steveAccount, String string2, double amount) {
		// TODO Auto-generated method stub
		
	}


	public Double interestCalculator(String string, int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<BankAccount> getAccounts(){
		List<BankAccount> accounts = new ArrayList<>();
		if (checking != null) {
			accounts.add(checking);
		}
		if (savings != null) {
			accounts.add(savings);
		}
		return accounts;
	}
	
	public void changeAccountName(String type, String newName) {
		if (type.equals("C")) {
			if (checking != null) {
				checking.setAccountName(newName);
			}
			else {
				System.err.println("Checking account does not exist.");
			}
		}
		else if (type.equals("S")) {
			if (savings != null) {
				savings.setAccountName(newName);
			}
			else {
				System.err.println("Savings account does not exist.");
			}
		}
		else {
			System.err.println("Invalid input.");
		}
	}

}
