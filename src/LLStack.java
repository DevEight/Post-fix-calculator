/**
 * A class that implements the Stack interface using an ArrayList to hold the elements.
 * All single element actions used through ArrayList have a time complexity of O(1).
 * 
 * @author Bjorn Tegelund
 */

import java.util.EmptyStackException;
import java.util.LinkedList;

public class LLStack<T> implements Stack<T> {
	LinkedList<T> stack;
	
	/**
	 * Creates a new LLStack.
	 */
	public LLStack() {
		stack = new LinkedList<T>();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void push(T element) {
		System.out.println("Added: " + element);
		stack.addLast(element);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T pop() throws EmptyStackException {
		if(isEmpty())
			throw new EmptyStackException();
		
		System.out.println("Removed: " + stack.getLast());
		return stack.removeLast();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T top() throws EmptyStackException {
		if(isEmpty())
			throw new EmptyStackException();
		
		System.out.println("Got: " + stack.getLast());
		return stack.getLast();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		return stack.size();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		if(stack.isEmpty())
			return true;
		return false;
	}
}
