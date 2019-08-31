
/* 
 * BalanceScale.java 
 * 
 * Version: 
 *     1.4
 * 
 * Revisions: 
 *     7
 */


/**
 * This program prints is made to simulate
 * a balance scale where a weight at the left end
 * needs to be balanced with the given weights 
 * and the one which has the maximum number of 
 * weights are to be printed
 *
 * @author      Arjun Ravikumar
 * @author      Divya Kumar
 */


public class BalanceScale {
	static int[] myWeights 	= { 1, 2, 3, 4, 5, 7, 8, 12, 20, 35, 61 ,80};
    static int[] toWeigh  	= { 1, 6, 7, 9, 24, 110, 111, 115, 62, 
    						    24, 202, 203, 204, 205 };
    static Boolean 	found 		= false; 	//this variable is used to check if
    										//a solution for a purticular weight
    										// has been found or not

    /**
	* This function is called from the main function it calls the function 
	* findTheCombinationOfTheWeights which actually checks for all the 
	* weight combinations and if the found is still false after it's execution
	* then this function prints that there are no possible combinations
	*
	* @param 	weight	the weight who's combinations are to be found out
	*
	*/

    static void testIfaCombinationForThisWeightExist(int weight) {
    	int lengthMyWeight = myWeights.length; 
    	int[] arr = new int[lengthMyWeight];
    	found = false;
    	findTheCombinationOfTheWeights(arr,0,lengthMyWeight,weight,weight);
    					//Calling the function to find all combiniations
    	if(found == false)
    	{
    		System.out.println(weight+"g:\tno;");
    		//if found is still false then printed that weight is not possible
    	}
    }

    /**
	* This is the function which does most of the work in the program 
	* this function is recursively called by itself 
	* to find all the combination that weigh up to the weight provided
	* also print the possible combination
	*
	* @param 	combinationArray	the array which hold the combination of the
	*								currently considered elements from myWeight
	* @param 	currIndex			Index pointing to the array myWeights 
	*								to show the element which is being checked
	* @param 	length				the length of myWeight
	*								
	* @param 	weight				the weight which is to be checked
	*								
	* @param 	diff				the current difference after the weight
	*								is reduced with each element being 
	*								pushed into currIndex
	*
	*/


    static void findTheCombinationOfTheWeights(int[] combinationArray,
    	int currIndex,int length,int weight,int diff){
    	int sum = 0;
    	WeightsArray weightArray = new WeightsArray();
    	if(found == true){
    		//to stop once an output is found
    		return;
    	}
    	if(diff < 0){
    		//to skip the iteration once the difference is less than 0
    		return;
    	}
    	else if(diff == 0){
    		for(int combinationArrayIndex = 0; combinationArrayIndex< currIndex; combinationArrayIndex++){
    			weightArray.push(combinationArray[combinationArrayIndex]);
    		}

    		for(int weightArrayIndex = 0; weightArrayIndex< weightArray.length(); weightArrayIndex++){
    			sum += weightArray.getItemAt(weightArrayIndex);
    		}

    		if(sum == weight){
    			//to print the solution
    			System.out.printf("%dg:\tyes; used myWeights = ",weight);
    			for(int index = 0; index< weightArray.length();index++){
    				System.out.printf("%dg ",weightArray.getItemAt(index));
    			}
    			System.out.println();
    			found = true;
    			return;
    		}
    	}
    	//to start from the previously inserted value
    	//into the combination array
    	int previousIndexInserted = 0;
    	if(currIndex == 0){
    		previousIndexInserted = 0;
    	}
    	else{
    		for(int myWeightsIndex = 0; myWeightsIndex< length; myWeightsIndex ++){
    			if(combinationArray[currIndex-1] == myWeights[myWeightsIndex]){
    				previousIndexInserted = myWeightsIndex + 1;
    				break;
    			}
    		}
    	}
    	//will iterate every value 
    	//after the last instered value into combinationArray
    	for(int myWeightsIndex = previousIndexInserted; myWeightsIndex < length; myWeightsIndex++){
    		if(myWeights[myWeightsIndex] <= weight) {
    			combinationArray[currIndex] =  myWeights[myWeightsIndex];
    			//recursively calling the function to check all combinations
    			findTheCombinationOfTheWeights(combinationArray,
    				currIndex+1,length,weight,diff-myWeights[myWeightsIndex]);
    		}
    	}
    }

    /**
	* The main function it fetches new weights to check from toWeigh
	* and calls function testIfaCombinationForThisWeightExist
	*
	* @param 	arguments	ignored
	*
	*/

    public static void main( String[] arguments ) {
        for ( int index = 0; index < toWeigh.length; index ++ ) {
        	testIfaCombinationForThisWeightExist(toWeigh[index]);
        }
	}
}

/**
 * This class is made to simulate an array function
 * it has the functionality of push to insert a new element
 *
 */

class WeightsArray {
	static int[] weightArr = new int[100];
	static int lastIndex;

	/**
	* The constructor function to initialise the values and clear the array
	*
	*/

	public WeightsArray(){
		clearArr();
		lastIndex = 0;
	}

	/**
	* This function returns the item at a specific index
	*
	* @param 	index 				index of the number to be found out
	*
	* @return 	weightArr[index]    	returns the value at that index
	*
	*/

	public int getItemAt(int index)
	{
		return weightArr[index];
	}

	/**
	* The push function inserts the value given into the array
	*
	* @param 	val 	the value to be inserted into the array	
	*
	*/

	public void push(int val){
		weightArr[lastIndex] = val;
		lastIndex++;
	}

	/**
	* This function returns the length of the array
	*
	* @return 	lastIndex    	returns the length
	*
	*/

	public int length(){
		return lastIndex;
	}

	/**
	* This function clears the array
	*
	*/

	public void clearArr(){
		weightArr = null;
		weightArr = new int[100];
	}
}