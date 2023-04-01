/* 
 * William Kloppenberg
 * william.kloppenberg@mymail.champlain.edu
 * Final Project
 * 
 */

package bank;

public class CheckingAccount extends BankAccount {

	public CheckingAccount(String name) {
		super(name);
	}

	@Override
	public void withdraw(double amount) {
		if (balance < amount) {
			System.out.println("Insufficient Funds.");
		}
		else {
			balance -= amount;
			System.out.print("You withdrew $" + amount + "\n\n");
		}
	}
}
