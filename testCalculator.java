import static org.junit.Assert.*;

import org.junit.Test;

public class testCalculator {

	@Test
	public void testAdd() {
		assertEquals(5,Calculator.add(3,2));
	}
	@Test
	public void testSubtract() {
		assertEquals(4, Calculator.subtract(16, 12));
	}

	@Test
	public void testMultiply(){
		assertEquals(42, Calculator.multiply(6, 7));
	}

	
	
}

