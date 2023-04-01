/* 
 * William Kloppenberg
 * william.kloppenberg@mymail.champlain.edu
 * Final Project
 * 
 */

package bank;

public abstract class BankAccount {
	
	String accountName = "";
	double balance = 0.0;
	
	BankAccount(String name) {
		this.accountName = name;
	}
	
	// Final methods
	public final void deposit(double amount) {
		this.balance += amount;
		System.out.print("You deposited $" + amount + "\n\n");
	}
	
	public final String getAccountName() {
		return accountName;
	}
	
	public final double getBalance() {
		return balance;
	}
	
	// Method to be implemented by subclasses
	public abstract void withdraw(double amount);
	
}
