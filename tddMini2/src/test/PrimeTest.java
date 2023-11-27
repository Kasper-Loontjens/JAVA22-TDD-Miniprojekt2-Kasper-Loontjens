package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Prime;

class PrimeTest {
	
	@Test
	@DisplayName("1,5 should have prime numbers 2,3,5")
	void prime2To5Test() {
		Prime prime = new Prime(1, 5);
		System.out.println("1,5: "+prime.getPrimes());

		assertEquals(2, prime.getPrimes().get(0));
		assertEquals(3, prime.getPrimes().get(1));
		assertEquals(5, prime.getPrimes().get(2));
		// Originally got 1,2,3,4,5,5,14
		// numIsPrime method returned all numbers as it returned true when depth was 0
		// Changed it to only return true if depth reached current as no numbers above that needs checking
	}
	
	@Test
	@DisplayName("1,2 should have prime numbers 2")
	void prime1To2Test() {
		Prime prime = new Prime(1, 2);
		System.out.println("1,2: " + prime.getPrimes());

		assertEquals(2, prime.getPrimes().get(0));
		// Originally got 1,2,2,3
	}
	@Test
	@DisplayName("5,10 should have prime numbers 2,7")
	void prime5To10Test() {
		Prime prime = new Prime(5, 10);
		System.out.println("5,10: " + prime.getPrimes());

		assertEquals(5, prime.getPrimes().get(0));
		assertEquals(7, prime.getPrimes().get(1));

	}
	
	@Test
	@DisplayName("50,100 should have prime numbers 53,59,61,67,71,73,79,83,89,97")
	void prime50To100Test() {
		Prime prime = new Prime(50, 100);
		System.out.println("5,10: " + prime.getPrimes());

		assertEquals(53, prime.getPrimes().get(0));
		assertEquals(59, prime.getPrimes().get(1));
		assertEquals(61, prime.getPrimes().get(2));
		assertEquals(67, prime.getPrimes().get(3));
		assertEquals(71, prime.getPrimes().get(4));
		assertEquals(73, prime.getPrimes().get(5));
		assertEquals(79, prime.getPrimes().get(6));
		assertEquals(83, prime.getPrimes().get(7));
		assertEquals(89, prime.getPrimes().get(8));
		assertEquals(97, prime.getPrimes().get(9));

	}
	
	@Test
	@DisplayName("-5,2 should have prime numbers 2")
	void primeMinus5To2Test() {
		Prime prime = new Prime(-5, 2);
		System.out.println("-5,2: " + prime.getPrimes());

		assertEquals(2, prime.getPrimes().get(0));	
		assertNotEquals(2, prime.getPrimes().get(1));	
	}
	
	@Test
	@DisplayName("-5,1 should have no prime numbers")
	void primeMinus5To1Test() {
		Prime prime = new Prime(-5, 1);
		System.out.println("-5,2: " + prime.getPrimes());

		assertEquals(0, prime.getPrimes().get(0));	
		assertEquals(0, prime.getCount());

	}
	
	// getSumOfPrimes test
	// Originally had no way to get sum, created getter
	
	@Test
	@DisplayName("1,2 should have a sum of 2")
	void getSumOfPrime1To2Test() {
		Prime prime = new Prime(1, 2);
		System.out.println("1,2 sum: " + prime.getSumOfPrimes());

		assertEquals(2, prime.getSumOfPrimes());
		// Created getSumOfPrimes but it then returned 3
	}
	
	@Test
	@DisplayName("1,5 should have a sum of 10")
	void getSumOfPrime1To5Test() {
		Prime prime = new Prime(1, 5);
		System.out.println("1,5 sum: " + prime.getSumOfPrimes());

		assertEquals(10, prime.getSumOfPrimes());
		// Created getSumOfPrimes but it then returned 15
	}
	
	// getCount tests
	// Originally had no way to get count, created getter

	
	@Test
	@DisplayName("1,5 should have a count of 3 (2,3,5)")
	void getCount1To5Test() {
		Prime prime = new Prime(1, 5);
		System.out.println("1,5 count: " + prime.getCount());

		assertEquals(3, prime.getCount());
		// Created getCount but it then returned 5
	}
	
	@Test
	@DisplayName("1,2 should have a count of 1 (2)")
	void getCount1To2Test() {
		Prime prime = new Prime(1, 2);
		System.out.println("1,2 count: " + prime.getCount());

		assertEquals(1, prime.getCount());
		// Created getCount but it then returned 2
	}
	
	@Test
	@DisplayName("1000,10000 should have a count of 0 because first and lastnumber should be limited to 1000")
	void getCount1000To1000Test() {
		Prime prime = new Prime(1000, 10000);

		assertEquals(0, prime.getCount());
	}
	
	@Test
	@DisplayName("10000,10 should have a count of 0 because first number is higher than second number")
	void getCount10000To10Test() {
		Prime prime = new Prime(10000, 10);

		assertEquals(0, prime.getCount());
	}
	
	// numIsPrime tests
	// Made numIsPrime public for testing
	
	@Test
	@DisplayName("1 is not prime")
	void numIsPrime1Test() {
		Prime prime = new Prime(1, 2);
		assertFalse(prime.numIsPrime(1,2));
		// had to add a return false if current number was 1 or less
		// Made it so depth can´t be below 2  
	}
	
	@Test
	@DisplayName("2 is prime")
	void numIsPrime2Test() {
		System.out.println(""+ (8%1));
		Prime prime = new Prime(1, 2);
		assertTrue(prime.numIsPrime(2,2));
	}
	
	@Test
	@DisplayName("3 is prime")
	void numIsPrime3Test() {
		Prime prime = new Prime(1, 2);
		assertTrue(prime.numIsPrime(3,0));
	}
	
	@Test
	@DisplayName("4 is not prime")
	void numIsPrime4Test() {
		Prime prime = new Prime(1, 2);
		assertFalse(prime.numIsPrime(4,2));
	}
	
	@Test
	@DisplayName("5 is prime")
	void numIsPrime5Test() {
		Prime prime = new Prime(1, 2);
		assertTrue(prime.numIsPrime(5,2));
		// Method got "int divisibleBy = primes.get(depth)" which created errors once depth was higher than the number of items in list
		// Changed to "int divisibleBy = depth"
	}
	
	@Test
	@DisplayName("6 is not prime")
	void numIsPrime6Test() {
		Prime prime = new Prime(1, 2);
		assertFalse(prime.numIsPrime(6,2));
	}
	@Test
	@DisplayName("7 is a prime")
	void numIsPrime7Test() {
		Prime prime = new Prime(1, 2);
		assertTrue(prime.numIsPrime(7,2));
	}	
	@Test
	@DisplayName("8 is not prime")
	void numIsPrime8Test() {
		Prime prime = new Prime(1, 2);
		assertFalse(prime.numIsPrime(8,2));
	}
	
	// printCount tests
	
	@Test
	@DisplayName("printCount of 0,5 should return: Hey, there are 3 prime numbers between 0 and 5")
	void printCount0to5() {
		Prime prime = new Prime(0, 5);
		String message = "Hey, there are 3 prime numbers between 0 and 5";
		assertEquals(message, prime.printCount());
	}	
	@Test
	@DisplayName("printCount of 0,10 should return: Hey, there are 4 prime numbers between 0 and 10")
	void printCount0to10() {
		Prime prime = new Prime(0, 10);
		String message = "Hey, there are 4 prime numbers between 0 and 10";
		assertEquals(message, prime.printCount());
	}
	
	// printSum tests
	
	@Test
	@DisplayName("printSum of 0,5 should return: And the total sum of those numbers are 10")
	void printSum0to5() {
		Prime prime = new Prime(0, 5);
		String message = "And the total sum of those numbers are 10";
		assertEquals(message, prime.printSum());
	}
	@Test
	@DisplayName("printSum of 0,10 should return: And the total sum of those numbers are 17")
	void printSum0to10() {
		Prime prime = new Prime(0, 10);
		String message = "And the total sum of those numbers are 17";
		assertEquals(message, prime.printSum());
	}
	
}
