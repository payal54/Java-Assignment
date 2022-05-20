// Java program to evaluate a given expression

class GFG{
// A utility function to check if
// a given character is operand
static boolean isOperand(char c)
{
	return (c >= '0' && c <= '9');
	
}

// utility function to find value of and operand
static int value(char c)
{
	return (int)(c - '0');
	
}

// This function evaluates simple expressions.
// It returns -1 if the given
// expression is invalid.
static int evaluate(String exp)
{
	// Base Case: Given expression is empty
	if (exp.length() == 0) return -1;

	// The first character must be
	// an operand, find its value
	int res = value(exp.charAt(0));

	// Traverse the remaining characters in pairs
	for (int i = 1; i<exp.length(); i += 2)
	{
		// The next character must be an operator, and
		// next to next an operand
		char opr = exp.charAt(i), opd = exp.charAt(i+1);

		// If next to next character is not an operand
		if (isOperand(opd) == false) return -1;

		// Update result according to the operator
		if (opr == '+') res += value(opd);
		else if (opr == '-') res -= value(opd);
		else if (opr == '*') res *= value(opd);
		else if (opr == '/') res /= value(opd);

		// If not a valid operator
		else				 return -1;
	}
	return res;
}

// Driver program to test above function
public static void main(String[] args)
{
	String expr1 = "2+(5*(2-2))";
	int res = evaluate(expr1);
	if(res == -1) System.out.println(expr1+" is Invalid");
	else	 System.out.println("Value of "+expr1+" is "+res);

}
}