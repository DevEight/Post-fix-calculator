/**
 * The Stack interface defines a standard to be used by all classes wanting to implement a "Stack"-type class.
 * 
 * @author Björn Tegelund
 * @version 2011.02.01
 */
public interface Stack<T> {
	/**
	 * Push places the given element on the top of the stack.
	 * @param element The object to be placed onto the stack.
	 */
	public void push(T element);
	
	/**
	 * Pop removes the top element on the stack and returns it.
	 * @return The top element of the stack. Returns null if the stack is empty.
	 */
	public T pop();
	
	/**
	 * Top lets the user look at the topmost element on the stack, without removing it.
	 * @return The topmost element on the stack. Returns null if the stack is empty.
	 */
	public T top();
	
	/**
	 * Returns an integer containing the number of elements on the stack.
	 * @return An integer containing the number of elements on the stack.
	 */
	public int size();
	
	/**
	 * Lets the user know if the stack is empty or not.
	 * @return True if the stack is empty, false if it is not.
	 */
	public boolean isEmpty();
}
