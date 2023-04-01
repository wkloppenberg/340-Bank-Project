/* 
 * William Kloppenberg
 * william.kloppenberg@mymail.champlain.edu
 * Final Project
 * 
 */

package main;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class BankClient {
	private static int choice;
	public static void main(String args[]) throws NumberFormatException, IOException {
		Scanner scan = new Scanner(System.in);
		BankFront bankfront = new BankFront();
		
		do {
			
			System.out.print("*** WELCOME TO THE BANK ***\n");
			System.out.print("1. Create Account\n");
			System.out.print("2. Deposit\n");
			System.out.print("3. Withdraw\n");
			System.out.print("4. Display Account Info\n");
			System.out.print("5. Quit\n");
			System.out.print("Select one: ");
			
			BufferedReader buffRead = new BufferedReader(new InputStreamReader(System.in));
			choice = Integer.parseInt(buffRead.readLine());
			
			switch (choice) {
			case 1:
				{
					System.out.print("Select preferred account type (C for Checking | S for Savings): ");
					String accountType = scan.nextLine();
					System.out.print("Enter account name: ");
					String accountName = scan.nextLine();
					bankfront.newAccount(accountType, accountName);
					bankfront.display(accountType);
				}
				break;
			case 2:
				{
					System.out.print("Select account to deposit to (C for Checking | S for Savings): ");
					String accountType = scan.nextLine();
					System.out.print("Enter amount to deposit: $");
					double amount = scan.nextDouble();
					bankfront.deposit(accountType, amount);
				}
				break;
			case 3:
				{
					System.out.print("Select account to withdraw from (C for Checking | S for Savings): ");
					String accountType = scan.nextLine();
					System.out.print("Enter amount to withdraw: $");
					double amount = scan.nextDouble();
					bankfront.withdraw(accountType, amount);
				}
				break;
			case 4:
				{
					System.out.print("Select account to display (C for Checking | S for Savings): ");
					String accountType = scan.nextLine();
					bankfront.display(accountType);
					System.out.print("\n");
				}
				break;
			default:
				{
					System.out.print("Thank you for coming!\n\n");
				}
				return;
			}
		} while (choice != 5);
	}
}