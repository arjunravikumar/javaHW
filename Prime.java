
/* 
 * Prime.java 
 * 
 * Version: 
 *     2.1
 * 
 * Revisions: 
 *     16
 */


/**
 * This program prints out the sum of
 * the prime factorials for non-prime numbers
 * where the non-prime number is the product 
 * of two prime numbers
 * @author      Arjun Ravikumar
 */



class Prime {

	/**
   	* Check if the given number is prime or not
   	* and return the status
   	*
   	* @param    n    rumber to check if prime
   	*/

   	static final int LIMIT = 15; //will take prime numbers <= LIMIT

	static boolean isPrime(int n) {
		for( int index = 2; index < n; index ++ ) {
			if( n % index  == 0 )
				return false;
		}
		return true;
	}


	/**
   	* Given prime numbers and thier length
   	* output the the sum and product of the primenumbers
   	*
   	* @param    primeNumbers    the array of prime numbers
   	* @param    countOfPrimeNumbers    length of primeNumbers Array
   	*/

	static void printSumOfAllPrimes(int primeNumbers[], int countOfPrimeNumbers){
		for (int index = 0;index < countOfPrimeNumbers; index++){
			for (int index1 = index;index1 < countOfPrimeNumbers; index1++){
				var firstPrime = primeNumbers[index];
				var secondPrime = primeNumbers[index1];
				System.out.println("The sum of all primes for "+ firstPrime*secondPrime
					+ ":\t"+(firstPrime+secondPrime)
					+"\t("+firstPrime + " + "+ secondPrime + ")");
			}
		}
	}

	/**
   	* main function
   	* 
   	*
   	* @param    n    number to check if prime
   	*/
	
	public static void main( String args[] ) {
		int[] primeNumbers = new int[LIMIT/2]; //length will be always < limit/2
		int countOfPrimeNumbers = 0;
		for ( int index = 2; index <= LIMIT; index++){
			if ( isPrime(index) ){
				primeNumbers[countOfPrimeNumbers] = index;
				countOfPrimeNumbers++;
			}
		}
		printSumOfAllPrimes(primeNumbers,countOfPrimeNumbers);
	}
}
