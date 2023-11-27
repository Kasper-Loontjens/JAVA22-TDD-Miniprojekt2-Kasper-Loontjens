package main;
import java.util.ArrayList;
import java.util.List;


/**
* This program counts the sum and the number of prime (int) numbers in interval 0-1000
*/
public class Prime {

    private List<Integer> primes;
    private int count = 0;
    private int sumOfPrimes = 0;
    private int firstNumber;
    private int lastNumber;


    public Prime(int firstNumber, int lastNumber) {
    	this.firstNumber = firstNumber;
    	this.lastNumber = lastNumber;
    	if (firstNumber > 1000) {
			firstNumber = 1000;
			System.out.println("Sorry no numbers above 1000");
		}
    	if (lastNumber > 1000) {
			lastNumber = 1000;
			System.out.println("Sorry no numbers above 1000");

		}
        primes = new ArrayList<>();
        calculatePrimes(firstNumber, lastNumber);
    }

    public boolean numIsPrime(int current, int depth) {
        if (depth < 2) {
			depth = 2;
		}
    	if (current <= 1) {
			return false;
		}
        if (depth >= current) {
            return true;
        }

        
        
        int divisibleBy = depth;
        if (current % divisibleBy == 0 ) {
            return false;
        }
        
        return numIsPrime(current, (depth+1));
    }

    private void calculatePrimes(int current, int stop) {
        if (current > stop) {
            primes.add(count);
            primes.add(sumOfPrimes);
        } else if (numIsPrime(current, 2)) {
            primes.add(current);
            ++count;
            sumOfPrimes += current;
            calculatePrimes(++current, stop);
        } else {
            calculatePrimes(++current, stop);
        }
    }
    
    public String printCount() {
		String message = "Hey, there are "+ getCount() +" prime numbers between "+firstNumber+" and "+ lastNumber;

		return message;
	}    
    public String printSum() {
		String message = "And the total sum of those numbers are " + getSumOfPrimes();

		return message;
	}

    public List<Integer> getPrimes() {
        return primes;
    }
    public int getSumOfPrimes() {
		return sumOfPrimes;
	}
    public int getCount() {
 		return count;
 	}
}
