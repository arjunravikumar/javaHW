/* 
 * BalanceScaleLeftRight.java 
 * 
 * Version: 
 *     1.2
 * 
 * Revisions: 
 *     4
 */


/**
 * This program prints is made to simulate
 * a balance scale where a weight at the left end
 * needs to be balanced with the given weights 
 * and the one which has the maximum number of 
 * weights are to be printed also wiegths can be added
 * one the left end as well if the weights can't be balanced
 * just by adding weights on the right side
 *
 * @author      Arjun Ravikumar
 * @author      Divya Kumar
 */


public class BalanceScaleLeftRight {
    static int[]    myWeights       = { 5, 8, 12, 35, 61, 150 };
    static int[]    toWeight        = { 2, 3, 4, 8, 9 , 40, 150, 151, 152 };
    static Boolean  found           = false;    //this variable is used to check if
                                                //a solution for a purticular weight
                                                // has been found or not
    static WeightsArray weightArray = new WeightsArray();

    /**
    * This function is called from the getAllSubSets function 
    * it calls the function findTheCombinationOfTheWeights which 
    * actually checks for all the weight combinations
    *
    * @param    weight  the weight who's combinations are to be found out
    *
    */

    static void testIfaCombinationForThisWeightExist(int weight) {
        int lengthMyWeight = myWeights.length; 
        int[] arr = new int[lengthMyWeight];
        findTheCombinationOfTheWeights(arr,0,lengthMyWeight,weight,weight);
    }

    /**
    * this function is recursively called by itself 
    * to find all the combination that weigh up to the weight provided
    *
    * @param    combinationArray    the array which hold the combination of the
    *                               currently considered elements from myWeight
    * @param    currIndex           Index pointing to the array myWeights 
    *                               to show the element which is being checked
    * @param    length              the length of myWeight
    *                               
    * @param    weight              the weight which is to be checked
    *                               
    * @param    diff                the current difference after the weight
    *                               is reduced with each element being 
    *                               pushed into currIndex
    *
    */

    static void findTheCombinationOfTheWeights(int[] combinationArray,
        int currIndex,int length,int weight,int diff){
        if(found == true){
            //to stop once an output is found
            return;
        }
        int sum = 0;
        weightArray = new WeightsArray();
        if(diff < 0){
            //to skip the iteration once the difference is less than 0
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
                //solution is possible if it enters here
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
            for(int index = 0; index< length; index ++){
                if(combinationArray[currIndex-1] == myWeights[index]){
                    previousIndexInserted = index + 1;
                    break;
                }
            }
        }
        //will iterate every value 
        //after the last instered value into combinationArray
        for(int index = previousIndexInserted;index < length;index++){
            if(myWeights[index] <= weight) {
                combinationArray[currIndex] =  myWeights[index];
                //recursively calling the function to check all combinations
                findTheCombinationOfTheWeights(combinationArray,
                    currIndex+1,length,weight,diff-myWeights[index]);
            }
        }
    }

    /**
    * The main function it fetches new weights to check from toWeigh
    * and calls function getAllSubSets
    *
    * @param    arguments   ignored
    *
    */

    public static void main( String[] arguments ) {
        for ( int index = 0; index < toWeight.length; index ++ ) {
            found = false;
            getAllSubSets(myWeights,toWeight[index]);
        }
    }

    /**
    * the getAllSubSets function gets the all the subset of myWeights array
    * and calls testIfaCombinationForThisWeightExist for testing if
    * any combination is possible for the given weight
    *
    * @param    set                 the myWeights set
    * @param    weightToBeChecked   the weight to be checked for combinations
    *
    */

    static void getAllSubSets(int[] set,int weightToBeChecked) 
    { 
        int[] setInSubSets;
        int sumOfSubSets = 0;
        int count = 0;
        int length = set.length; 
        // loop for checking all the 2^length possible subsets
        // limit is next binary integer of length
        for (int index = 0; index < (1<<length); index++){
            setInSubSets = new int[set.length];
            count = 0;
            sumOfSubSets = 0;
            for (int jindex = 0; jindex < length; jindex++){
                //binary "and" operation of every bit in index and right shift jindex
                if ((index & (1 << jindex)) > 0){ 
                    //sum of the subsets stored
                    sumOfSubSets+= set[jindex];
                    //the subsets stored in array
                    setInSubSets[count++] = set[jindex];
                }
            }
            //calls the function for checking for each subset
            testIfaCombinationForThisWeightExist(weightToBeChecked+sumOfSubSets);
            if(found == true)
            {
                //output the value if found
                System.out.printf("%dg ",weightToBeChecked);
                for(int subSetindex = 0; subSetindex< count; subSetindex++){
                    System.out.printf("%dg ",setInSubSets[subSetindex]);
                }
                System.out.printf("\t| ");
                for(int myWeightIndex = 0; myWeightIndex< weightArray.length();myWeightIndex++){
                    System.out.printf("%dg ",weightArray.getItemAt(myWeightIndex));
                }
                System.out.println();
                break;
            }
        }
        if(found == false)
        {
            //output the value if not found
            System.out.println(weightToBeChecked+"g:\tno;");
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
        weightArr = new int[100];
        lastIndex = 0;
    }

    /**
    * This function returns the item at a specific index
    *
    * @param    index               index of the number to be found out
    *
    * @return   weightArr[index]        returns the value at that index
    *
    */


    public int getItemAt(int index)
    {
        return weightArr[index];
    }


    /**
    * The push function inserts the value given into the array
    *
    * @param    val     the value to be inserted into the array 
    *
    */

    public void push(int val){
        weightArr[lastIndex] = val;
        lastIndex++;
    }

    /**
    * This function returns the length of the array
    *
    * @return   lastIndex       returns the length
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
    }
}