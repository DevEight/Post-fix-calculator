import java.util.Scanner;

/**
 * A Calculator class used to process strings containing instructions for basic mathematical operations in post-fix notation.
 * 
 * @author Björn Tegelund
 * @version 2011.02.01
 */
public class Calculator {
	/**
	 * The Operation data-structure is used to:
	 * - Associate characters with mathematical operations
	 * - Define methods which should be run when certain operators are found
	 */
	private enum Operation {
		ADDITION('+') { int eval(int x, int y) { return x + y; } },
		SUBTACTION('-') { int eval(int x, int y) { return y - x; }},
		MULTIPLICATION('*') { int eval(int x, int y) { return x*y; }},
		DIVISION('/') { int eval(int x, int y) { return y/x; }};
		
		/*
		 * Each operation takes two parameters and returns an integer.
		 */
		abstract int eval(int x, int y);
		
		/**
		 * Each operation has a character associated with it.
		 */
		private char character;
		
		/*
		 * Defines what character should be associated with an operation.
		 */
		private Operation(char c) {
			character = c;
		}
	}
	
	private LLStack<Integer> stack;
	private Scanner sc;
	
	public Calculator() {
		//Empty
	}
	
	/**
	 * Runs the operation that has been associated with a character found in the input string.
	 * @param op The operation to be run.
	 */
	private void executeOperation(Operation op) {
		stack.push(op.eval(stack.pop(), stack.pop()));
	}
	
	/**
	 * Checks to see if the given string is in fact a number.
	 * 
	 * @param s The string to be checked.
	 * @return True if the string can be converted into a number, false if not.
	 */
	private boolean isANumber(String s) {
		if(s == null || s.length() == 0)
			return false;
		
		try {
			Integer.parseInt(s);
		}
		catch(NumberFormatException e) {
			return false;
		}
		System.out.println(s + " is a number.");
		return true;
	}
	
	/**
	 * Processes a string containing numbers and valid mathematical operators.
	 * 
	 * @param input The string that should be processed.
	 * @return The result of the string, represented as a number.
	 */
	public int process(String input) throws IllegalArgumentException {
		sc = new Scanner(input);
		stack = new LLStack<Integer>();
		
		if(!sc.hasNext())
			throw new IllegalArgumentException();
		
		while(sc.hasNext()) {
			String nextInput = sc.next();

			if(isANumber(nextInput)) {
				stack.push(Integer.parseInt(nextInput));
			}
			//if nextInput.length() != 1 the string is invalid.
			else if(nextInput.length() == 1) {
				char c = nextInput.charAt(0);
				Operation opToRun = null;
				
				for(Operation op : Operation.values()) {
					if(c == op.character) {
						opToRun = op;
						break;
					}
				}
				if(opToRun != null && stack.size() >= 2)
					executeOperation(opToRun);
				else
					throw new IllegalArgumentException();
			}
			else {
					throw new IllegalArgumentException();
			}
		}
		
		if(stack.size() != 1)
			throw new IllegalArgumentException();
		
		return stack.pop();
	}
}
