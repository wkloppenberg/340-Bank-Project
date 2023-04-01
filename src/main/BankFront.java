/* 
 * William Kloppenberg
 * william.kloppenberg@mymail.champlain.edu
 * Final Project
 * 
 */

package main;

public class BankFront {
	
	private bank.BankAccount checking;
	private bank.BankAccount savings;
	
	public BankFront() {
	}
	
	
	public void newAccount(String type, String name) {
		if (type.equals("C")) {
			checking = new bank.CheckingAccount(name);
		}
		else if (type.equals("S")) {
			savings = new bank.SavingsAccount(name);
		}
	}
	
	public void deposit(String type, double amount) {
		if (type.equals("C")) {
			checking.deposit(amount);
		}
		else if (type.equals("S")) {
			savings.deposit(amount);
		}
	}
	
	public void withdraw(String type, double amount) {
		if (type.equals("C")) {
			checking.withdraw(amount);
		}
		else if (type.equals("S")) {
			savings.withdraw(amount);
		}
	}
	
	public void display(String type) {
		if (type.equals("C")) {
			System.out.print("\n");
			System.out.println("CHECKING ACCOUNT INFORMATION");
			System.out.println("Name: " + checking.getAccountName());
			System.out.println("Balance: " + checking.getBalance());
		}
		else if (type.equals("S")) {
			System.out.print("\n");
			System.out.println("SAVINGS ACCOUNT INFORMATION");
			System.out.println("Name: " + savings.getAccountName());
			System.out.println("Balance: " + savings.getBalance());
		}
		System.out.print("\n");
	}

}
