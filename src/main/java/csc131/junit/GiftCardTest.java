package csc131.junit;

/***************************
*    Jabari Crenshaw       *
*      CSC 131             *
*      03 March 2021       *
*      GiftCardTest.java   *
****************************/

import static org.junit.Assert.*;
import org.junit.*;

public class GiftCardTest {
	
   //TESTING getIssuingStore() 
   @Test
   public void testGetIssuingStore() {
      int issuingStore = 1337;
      double balance = 100.00;
      GiftCard card = new GiftCard(issuingStore, balance);
   	
      assertEquals("testsGetIssuingStore()", issuingStore, card.getIssuingStore());
   }
	
   //TESTING getBalance()
   @Test
   public void testGetBalance() {
      int issuingStore = 420;
      double balance = 8232019.00;
      GiftCard card = new GiftCard(issuingStore, balance);
   	
      assertEquals("testGetBalance()", balance, card.getBalance(), 0.001);
   	
   }
	
   //TESTING deduct()
   @Test
   public void deduct_RemainingBalance() {
      int issuingStore = 2020;
      double balance = 314.18;
      GiftCard card = new GiftCard(issuingStore, balance);
   	
      double purchaseTotal = 15.47;
      String remainingBalance = "Remaining Balance: " + (balance - purchaseTotal);
   	
      assertEquals("testDeduct_RemainingBalance()", remainingBalance, card.deduct(purchaseTotal));
   }
	
	//TESTING if (storeID > MAX_ID)
   @Test
   public void constructor_IncorrectID_High() {
      int issuingStore = 101010;
      double balance = 314.18;
   	
      assertThrows(IllegalArgumentException.class, () -> {new GiftCard(issuingStore, balance);});
   }
	
   //TESTING -- > if (storeID < 0)
   @Test
   public void constructor_IncorrectID_Low() {
      int issuingStore = -5;
      double balance = 314.18;
   	
      assertThrows(IllegalArgumentException.class, () -> {new GiftCard(issuingStore, balance);});
   }
   
   //TESTING --> if (openingBalance < 0.00)
   @Test
   public void testGiftCard_openingBalance() {
      int issuingStore = 2020;
      double balance = -12;
   	
      assertThrows(IllegalArgumentException.class, () -> {new GiftCard(issuingStore, balance);});
   }
	
   //TESTING if --> (transaction total > balance)
   @Test
   public void testDeduct_negativeBalance() {
      int issuingStore = 2020;
   	
      double balance = 12.00;
      GiftCard card = new GiftCard(issuingStore, balance);
   	
      double purchaseTotal = 15.50;
   	//String remainingBalance = "Remaining Balance: " + (balance - purchaseTotal);
      String stimulusPending = "Amount Due: " + (String.format("%6.2f", Math.abs(purchaseTotal - balance)));
      assertEquals("testDeduct2()", stimulusPending, card.deduct(purchaseTotal));
   }
	
   //TESTING if --> (transaction total < 0)
   @Test
   public void testDeduct_negativeTransaction() {
      int issuingStore = 2020;
      double balance = 314.18;
      GiftCard card = new GiftCard(issuingStore, balance);
   	
      double purchaseTotal = -7.00;
   	//String remainingBalance = "Remaining Balance: " + (balance - purchaseTotal);
      String doNotGiveAwayMoney = "Invalid Transaction";
      assertEquals("testDeduct2()", doNotGiveAwayMoney, card.deduct(purchaseTotal));
   }

}
