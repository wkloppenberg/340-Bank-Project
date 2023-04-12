// Made by Spack


package test;


import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.*;

import main.*;
import bank.*;

public class BankTest {
	
	private ByteArrayOutputStream out = new ByteArrayOutputStream();
	
	BankFront joeAccount;
	CheckingAccount joeChecking = new CheckingAccount("joe");
	SavingsAccount joeSavings = new SavingsAccount("joe");
	
	BankFront steveAccount;
	CheckingAccount steveChecking = new CheckingAccount("Steve");
	SavingsAccount steveSavings = new SavingsAccount("Steve");
	
	double amount = 500.00;
	
	@BeforeEach
	public void setup() {
		joeAccount = new BankFront();
		joeChecking.deposit(1500.00);
		joeSavings.deposit(3672.89);
		
		steveAccount = new BankFront();
		steveChecking.deposit(2000.00);
		steveSavings.deposit(1800.00);
	}

	@Test
	public void testTransferFromCheckingToSavings() {
		assertTrue(joeChecking.getBalance() >= amount);
		assertTrue(joeSavings != null);
		
		joeAccount.transferFromCheckingToSavings(amount);

		assertEquals(1000.00, joeChecking.getBalance());
		assertEquals(4172.89, joeSavings.getBalance());
	}
	
	@Test
	public void testTransferFromSavingsToChecking() {
		assertTrue(joeSavings.getBalance() >= amount);
		assertTrue(joeChecking != null);
		
		joeAccount.transferFromSavingsToChecking(amount);
	
		assertEquals(2000.00, joeChecking.getBalance());
		assertEquals(3172.89, joeChecking.getBalance());
	}
	
	@Test
	public void testTransferToOtherAccount() {
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
	
	// William's tests
	@Test
	public void testGetAccounts() {
        BankFront bankFront = new BankFront();
        bankFront.newAccount("C", "Jon");
        bankFront.newAccount("S", "Alex");
		BankAccount account = bankFront.getAccounts().get(0);
        assertEquals("Jon", account.getAccountName());
		BankAccount accountTwo = bankFront.getAccounts().get(1);
        assertEquals("Alex", accountTwo.getAccountName());
	}
	
    @Test
    public void testChangeAccountName() {
        BankFront bankFront = new BankFront();
        bankFront.newAccount("C", "Jon");
        bankFront.changeAccountName("C", "Jake");
        BankAccount account = bankFront.getAccounts().get(0);
        assertEquals("Jake", account.getAccountName());
    }
}
