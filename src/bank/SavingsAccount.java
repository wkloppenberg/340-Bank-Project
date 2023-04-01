/* 
 * William Kloppenberg
 * william.kloppenberg@mymail.champlain.edu
 * Final Project
 * 
 */

package bank;

public class SavingsAccount extends BankAccount {
	
	double interestRate = 0.08;
	
	public SavingsAccount(String name) {
		super(name);
	}

	@Override
	public void withdraw(double amount) {
		if (balance < amount) {
			System.out.println("Insufficient Funds.");
		}
		else {
			double interest = (amount * interestRate);
			balance -= (amount - interest);
			System.out.print("You withdrew $" + amount + "\n\n");
		}
	}
}
