package csc131.junit;

import static org.junit.Assert.*;
import org.junit.*;

public class GiftCardTest {
	
	@Test
	public void testGetIssuingStore() {
		int issuingStore = 1337;
		double balance = 100.00;
		GiftCard card = new GiftCard(issuingStore, balance);
		
		assertEquals("testsGetIssuingStore()", issuingStore, card.getIssuingStore());
		//Added a comment
	}
	
	@Test
	public void testGetBalance() {
		int issuingStore = 420;
		double balance = 8232019.00;
		GiftCard card = new GiftCard(issuingStore, balance);
		
		assertEquals("testGetBalance()", balance, card.getBalance(), 0.001);
		
	}
	
	@Test
	public void deduct_RemainingBalance() {
		int issuingStore = 2020;
		double balance = 314.18;
		GiftCard card = new GiftCard(issuingStore, balance);
		
		double purchaseTotal = 15.47;
		String remainingBalance = "Remaining Balance: " + (balance - purchaseTotal);
		
		assertEquals("testDeduct_RemainingBalance()", remainingBalance, card.deduct(purchaseTotal));
	}
	
	
	@Test
	public void testGiftCard1() {
		int issuingStore = 101010;
		double balance = 314.18;
		//TESTING if (storeID > MAX_ID)
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(issuingStore, balance);});
	}
	
	@Test
	public void testGiftCard2() {
		int issuingStore = -5;
		double balance = 314.18;
		//TESTING -- > if (storeID < 0)
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(issuingStore, balance);});
	}

	@Test
	public void testGiftCard3() {
		int issuingStore = 2020;
		double balance = -12;
		//TESTING --> if (openingBalance < 0.00)
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(issuingStore, balance);});
	}
	
	@Test
	public void testDeduct1() {
		int issuingStore = 2020;
		
		double balance = 12.00;
		GiftCard card = new GiftCard(issuingStore, balance);
		
		double purchaseTotal = 15.50;
		//String remainingBalance = "Remaining Balance: " + (balance - purchaseTotal);
		String stimulusPending = "Amount Due: " + (String.format("%6.2f",
                Math.abs(purchaseTotal - balance)));
		assertEquals("testDeduct2()", stimulusPending, card.deduct(purchaseTotal));
	}
	
	@Test
	public void testDeduct2() {
		int issuingStore = 2020;
		double balance = 314.18;
		GiftCard card = new GiftCard(issuingStore, balance);
		
		double purchaseTotal = -7.00;
		//String remainingBalance = "Remaining Balance: " + (balance - purchaseTotal);
		String doNotGiveAwayMoney = "Invalid Transaction";
		assertEquals("testDeduct2()", doNotGiveAwayMoney, card.deduct(purchaseTotal));
	}

}
