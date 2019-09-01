/* 
 * Expression.java 
 * 
 * Version: 
 *     1.0
 * 
 * Revisions: 
 *     0
 */

/**
 * This program inputs an mathematical expression 
 * and evaluates the result of the expression
 *
 * @author      Unknown
 */

import java.util.Vector;

public class Expression {

    /**
	* the main function creates the vector for storing the expression
	* calls the copyexpression for formatting the input to display as output
	* also calls the sum function which starts the evaluation of the expression
    *
    * @param    args  ignored
    *
    */

	public static void main (String args []) {
		// Vector<String> aLine = new Vector<String>(); // this would be correct
		Vector aLine = new Vector();	// this will compile,
						// but create the following messages
						// Note: Expression.java uses unchecked or unsafe
						// operations.
						// Note: Recompile with -Xlint:unchecked for details.
						// this is ok for the moment
		String expression; //not used anywhere
		
		aLine.add("2");
		aLine.add("^");
		aLine.add("3");
		aLine.add("^");
		aLine.add("2");
	/*
		for ( String arg: args ) {
			aLine.add(arg);
		}

		aLine.add("2");
		aLine.add("*");
		aLine.add("(");
			aLine.add("3");
			aLine.add("+");
			aLine.add("2");
		aLine.add(")");
		aLine.add("4");
	*/
		if ( aLine.size() > 0 )	{
			System.out.println(copyExpression(aLine) + " == " + sum(aLine) );
		}
	}

	/**
	* The copyExpression function basically inputs the vector 
	* and returns a string with spaces between each character
    *
    * @param    aLine  		the input vector which has the expression
    * @return   rValue      string with the expression formatted
    *
    */

    public static String copyExpression (Vector aLine) {
		String rValue = "";
		// returns the input with spaces between them
		for ( int index = 0; index < aLine.size(); index ++ )	{
			rValue += aLine.elementAt(index) + " ";
		}
		return rValue;
    }

    /**
	* The sum function is called from the main to evaluate the expression
	* it returns with the final result of the expression this function
	* call the product function which calls the power function
	* according to the precedence of different expressions 
    *
    * @param    s  		the vector which has the expression
    * @return   result  the result is of the expression after evaluation
    *
    */

    public static double sum (Vector s) {
		double result = product(s);
			
		while (s.size() > 0 ) {
			char op = ((String)s.elementAt(0)).charAt(0);
			switch (op) {
				case '+':
					s.remove(0);
					result = result +  product(s);
					continue;
				case '-':
					s.remove(0);
					result = result - product(s);
					continue;
				default:
					return result;
			}
		}
		return result;
    }

    /**
	* The sum function is called from the main to evaluate the expression
	* it returns with the final result of the expression this function
	* call the product function which calls the power function
	* according to the precedence of different expressions 
    *
    * @param    s  		the vector which has the expression
    * @return   result  the result is of the expression after evaluation
    *
    */

    public static double product (Vector s) {
	double result = power(s);
	if (s.size() == 0 )
		return result;
	while (s.size() > 0 ) {
		char op = ((String)s.elementAt(0)).charAt(0);
		switch (op) {
			case '*':
				s.remove(0);
				result = result * power(s);
				continue;
			case '/':
				s.remove(0);
				result = result / power(s);
				continue;
			case '%':
				s.remove(0);
				result = result % power(s);
				continue;
			default:
				return result;
		}
	}
	return result;
    }
    public static double power (Vector s) {
	double result = term(s);
	Vector<Double> aVector = new Vector<Double>();
	aVector.add( result );

	if (s.size() == 0 )
		return result;
	while (s.size() > 0 ) {
		char op = ((String)s.elementAt(0)).charAt(0);
		switch (op) {
			case '^':
				s.remove(0);
				double theTerm = term(s);
				aVector.add(theTerm);
				continue;
		}
	}
	return performPowerOperation(aVector);
    }

    public static double term (Vector s) {
	double result;
	result = Double.parseDouble(((String)s.elementAt(0)));
	s.remove(0);
	return result;
    }

    public static double performPowerOperation(Vector<Double> aVector)	{
		double result = 0.0;
		for (int index = 0; index < aVector.size(); index ++ )	{
			if ( aVector.size() >= 2 )	{
				double last = aVector.get( aVector.size() - 1);
				double secondLast = (double)aVector.get( aVector.size() - 2);
				result = Math.pow(secondLast, last);
				aVector.remove(aVector.size() - 2);
				aVector.remove(aVector.size() - 1);
				aVector.add( result);
			}
		}
		return aVector.get( 0 );
	}
}