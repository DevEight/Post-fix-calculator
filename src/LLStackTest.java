
import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class LLStackTest {
	LLStack<Integer> s;
	
	@Before
	public void setUp() throws Exception {
		s = new LLStack<Integer>();
		s.push(5);
		s.push(-3);
		s.push(1);
		s.push(null);
		s.push(83);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testPop() {
		Assert.assertSame(83, s.pop());
		Assert.assertSame(null, s.pop());
		Assert.assertSame(1, s.pop());
		
		s = new LLStack<Integer>();
		try {
			s.pop();
			fail("Should not work!");
		}
		catch(EmptyStackException e) {
		}
		s.push(null);
		s.push(null);
		Assert.assertSame(null, s.pop());
		Assert.assertSame(null, s.pop());
		try {
			s.pop();
			fail("Should not work!");
		}
		catch(EmptyStackException e) {
		}
	}
	
	@Test
	public void testTop() {
		Assert.assertSame(83, s.top());
		
		s = new LLStack<Integer>();
		try {
			s.top();
			fail("Should not work!");
		}
		catch(EmptyStackException e) {
		}
	}
	
	@Test
	public void testSize() {
		Assert.assertSame(5, s.size());
		s = new LLStack<Integer>();
		Assert.assertSame(0, s.size());
	}
	
	@Test
	public void testIsEmpty() {
		Assert.assertFalse(s.isEmpty());
		s = new LLStack<Integer>();
		Assert.assertTrue(s.isEmpty());
		s.push(null);
		Assert.assertFalse(s.isEmpty());
	}
}
