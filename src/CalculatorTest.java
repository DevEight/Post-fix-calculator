
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	Calculator calc;
	
	@Before
	public void setUp() throws Exception {
		calc = new Calculator();
	}

	@Test (expected=IllegalArgumentException.class)
	public void shouldntWork() {
		calc.process("1 - 2");
		calc.process(" ");
		calc.process("");
		calc.process("3 3");
		calc.process("2 /");
		calc.process("<");
		calc.process("2 2 c");
		calc.process("0 1 2 3 4");
		calc.process("1 2 + -");
		calc.process("- 1 2");
		calc.process("0 0 * *");
	}
	@Test
	public void testCalculator() {
		Assert.assertEquals(3, calc.process("3"));
		Assert.assertEquals(3, calc.process("2 1 +"));
		Assert.assertEquals(4, calc.process("8 2 /"));
		Assert.assertEquals(1, calc.process("4 3 -"));
		Assert.assertEquals(4, calc.process("2 2 *"));
		Assert.assertEquals(14, calc.process("3 4 + 4 * 2 /"));
		Assert.assertEquals(-7, calc.process("1 2 - 3 4 + *"));
		Assert.assertEquals(1, calc.process("1 2 + 3 * 4 - 5 /"));
		Assert.assertEquals(-12, calc.process("2 3 4 5 + - *"));
		Assert.assertEquals(1, calc.process("3 3 / 5 * 5 /"));
		Assert.assertEquals(0, calc.process("0 3 *"));
		Assert.assertEquals(-4, calc.process("-2 -2 +"));
		Assert.assertEquals(1,calc.process("-2 -2 - 2 + 2 /"));
		Assert.assertEquals(50, calc.process("5 5 5 5 5 5 5 5 5 5 + + + + + + + + +"));
		Assert.assertEquals(-1, calc.process("5 -5 /"));
	}
	
	@After
	public void tearDown() throws Exception {
	}
}
