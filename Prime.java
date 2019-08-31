
/* 
 * Prime.java 
 * 
 * Version: 
 *     3.0
 * 
 * Revisions: 
 *     19
 */


/**
 * This program prints out the sum of
 * the prime factorials for non-prime numbers
 * where the non-prime number is the product 
 * of two prime numbers
 * @author      Arjun Ravikumar
 */



class Prime {

	static final int LIMIT = 15; //will take prime numbers <= LIMIT

	/**
	* This function finds all the prime factors of a given number
	* and returns theprime factors when the count of the prime factors are 2
	*
	* @param 	numberToBeChecked	number whos prime factors are to be found
	*								out needs to be passed here
	*
	* @return 	primeFactors    	returns the list of prime factors when 
	*								the number of primefactors = 2
	*/

	static int[] findAllPrimeFactorsOfNumber(int numberToBeChecked) {
		int compositeNumber = numberToBeChecked;
		int index = 2;
		int[] primeFactors = new int[compositeNumber/2];
		int countOfPrimeFactors = 0;
		while(index <= (compositeNumber+1)/2) {		//the heighest primefactor
													//of n is n/2
			if(numberToBeChecked%index == 0) { 		
				numberToBeChecked = numberToBeChecked/index;	
				primeFactors[countOfPrimeFactors++] = index;	//primefactors-
																//stored here
			} else {
				index++;
			}
		}
		if(countOfPrimeFactors == 2){
			return primeFactors;	//returns if the primefactor count is == 2
		} else
		{
			return null;
		}
	}

	/**
	* main function
	* 
	* @param    args    command line arguments (ignored)
	*/
	
	public static void main( String args[] ) {
		int[] primeFactors = new int[2];
		for(int index = 3; index<= LIMIT;index++) {
			primeFactors = findAllPrimeFactorsOfNumber(index);
			if(primeFactors != null) {	//only numbers having 2 prime factors
										//will be passed here rest will be null
				int firstPrime = primeFactors[0];
				int secondPrime = primeFactors[1];
					System.out.println("The sum of all primes for "
						+ firstPrime*secondPrime+ ":\t" 
						+ (firstPrime+secondPrime)
						+"\t("+firstPrime + " + "+ secondPrime + ")");
			}
		}
	}
}
