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

import bank.BankAccount;

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
			System.out.print("5. Change Account Name\n");
			System.out.print("6. Quit\n");
			System.out.print("Select one: ");
			
			BufferedReader buffRead = new BufferedReader(new InputStreamReader(System.in));
			choice = Integer.parseInt(buffRead.readLine());
			
			switch (choice) {
			case 1:
				{
					System.out.print("Select preferred account type (C for Checking | S for Savings): ");
					String accountType = scan.nextLine().toUpperCase();
					System.out.print("Enter account name: ");
					String accountName = scan.nextLine();
					bankfront.newAccount(accountType, accountName);
					bankfront.display(accountType);
				}
				break;
			case 2:
				{
					System.out.print("Select account to deposit to (C for Checking | S for Savings): ");
					String accountType = scan.nextLine().toUpperCase();
					System.out.print("Enter amount to deposit: $");
					double amount = scan.nextDouble();
					scan.nextLine(); // Consume newline left in input buffer
					bankfront.deposit(accountType, amount);
				}
				break;
			case 3:
				{
					System.out.print("Select account to withdraw from (C for Checking | S for Savings): ");
					String accountType = scan.nextLine().toUpperCase();
					System.out.print("Enter amount to withdraw: $");
					double amount = scan.nextDouble();
					scan.nextLine(); // Consume newline left in input buffer
					bankfront.withdraw(accountType, amount);
				}
				break;
			case 4:
				{
					System.out.print("Select account to display (C for Checking | S for Savings): ");
					String accountType = scan.nextLine().toUpperCase();
					scan.nextLine(); // Consume newline left in input buffer
					bankfront.display(accountType);
					System.out.print("\n");
				}
				break;
			case 5:
			{
				System.out.print("Select account to change name (C for Checking | S for Savings): ");
				String accountType = scan.nextLine().toUpperCase();
				scan.nextLine(); // Consume newline left in input buffer
				System.out.print("Enter new name: ");
				String accountName = scan.nextLine();
				bankfront.changeAccountName(accountType, accountName);
			}
			break;
			default:
				{
					System.out.print("Thank you for coming!\n\n");
				}
				return;
			}
		} while (choice != 6);
	}
}