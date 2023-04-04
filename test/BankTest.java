package test;


import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.*;

import main.*;
import bank.*;

public class BankTest {
	
	BankFront joeAccount;
	CheckingAccount joeChecking;
	SavingsAccount joeSavings;
	
	BankFront steveAccount;
	CheckingAccount steveChecking;
	SavingsAccount steveSavings;
	
	double amount = 500.00;

	@BeforeEach
	public void setup() {
		joeAccount = new BankFront(joeChecking, joeSavings);
		joeChecking.deposit(1500.00);
		joeSavings.deposit(3672.89);
		
		steveAccount = new BankFront(steveChecking, joeSavings);
		steveChecking.deposit(2000.00);
		steveSavings.deposit(1800.00);
	}

	@Test
	public void testTransferFromCheckingToSavings(double amount) {
		assertTrue(joeChecking.getBalance() >= amount);
		assertTrue(joeSavings != null);
		
		joeAccount.transferFromCheckingToSavings(amount);
		
		assertEquals(1000.00, joeChecking.getBalance());
		assertEquals(4172.89, joeChecking.getBalance());
	}
	
	@Test
	public void testTransferFromSavingsToChecking(double amount) {
		assertTrue(joeSavings.getBalance() >= amount);
		assertTrue(joeChecking != null);
		
		joeAccount.transferFromSavingsToChecking(amount);
		
		assertEquals(2000.00, joeChecking.getBalance());
		assertEquals(3172.89, joeChecking.getBalance());
	}
	
	@Test
	public void testTransferToOtherAccount(double amount) {
		assertTrue(joeChecking.getBalance() >= amount);
		assertTrue(steveSavings != null);
		
		joeAccount.transferToOtherAccount("C", steveAccount, "S", amount);
		
		assertEquals(1000.00, joeChecking.getBalance());
		assertEquals(2300.00, steveSavings.getBalance());
		
	}
	
	@Test
	public void testInterestCalculator() {
		assertEquals(150.00, joeAccount.interestCalculator("C", 5));
		assertEquals(1101.87, joeAccount.interestCalculator("S", 15));
		assertEquals(400.00, steveAccount.interestCalculator("C", 10));
		assertEquals(1728.00, steveAccount.interestCalculator("S", 12));
	}
	
}
