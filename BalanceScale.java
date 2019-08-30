import java.util.*; 

public class BalanceScale {
	static int[] 	myWeights 	= { 1, 2, 3, 4, 5, 7, 8, 12, 20, 35, 61, 80};
    static int[] 	toWeight  	= { 1, 3, 4, 5, 7 , 12, 18, 20, 25, 29, 32};
    static Boolean 	found 		= false;

    static void testIfaCombinationForThisWeightExist(int weight) {
    	int lengthMW = myWeights.length; 
    	int[] arr = new int[lengthMW];
    	found = false;
    	findTheCombinationOfTheWeights(arr,0,lengthMW,weight,weight);
    }

    static void findTheCombinationOfTheWeights(int[] combinationArray,
    	int currIndex,int length,int weight,int diff){
    	int sum = 0;
    	WeightsArray weightArray = new WeightsArray();
    	if(found == true){
    		return;
    	}
    	if(diff < 0){
    		return;
    	}
    	else if(diff == 0){
    		for(int index = 0; index< currIndex;index++){
    			weightArray.push(combinationArray[index]);
    		}

    		for(int index = 0; index< weightArray.length();index++){
    			sum += weightArray.getItemAt(index);
    		}

    		if(sum == weight){
    			for(int index = 0; index< weightArray.length();index++){
    				System.out.printf("%d ",weightArray.getItemAt(index));
    			}
    			System.out.printf("| %d",weight);
    			System.out.println();
    			found = true;
    			return;
    		}
    	}
    	int previousIndexInserted = 0;
    	if(currIndex == 0){
    		previousIndexInserted = 0;
    	}
    	else{
    		for(int index = 0; index< length; index ++){
    			if(combinationArray[currIndex-1] == myWeights[index]){
    				previousIndexInserted = index + 1;
    				break;
    			}
    		}
    	}
    	for(int index = previousIndexInserted;index < length;index++){
    		if(myWeights[index] <= weight) {
    			combinationArray[currIndex] =  myWeights[index];
    			findTheCombinationOfTheWeights(combinationArray,
    				currIndex+1,length,weight,diff-myWeights[index]);
    		}
    	}
    }

    public static void main( String[] arguments ) {
        for ( int index = 0; index < toWeight.length; index ++ ) {
        	testIfaCombinationForThisWeightExist(toWeight[index]);
        }
	}
}

class WeightsArray {
	static int[] weightArr = new int[100];
	static int lastIndex;

	public WeightsArray(){
		clearArr();
		weightArr = new int[100];
		lastIndex = 0;
	}

	public int getItemAt(int index)
	{
		return weightArr[index];
	}

	public void push(int val){
		weightArr[lastIndex] = val;
		lastIndex++;
	}
	public int length(){
		return lastIndex;
	}

	public void clearArr(){
		weightArr = null;
	}
}