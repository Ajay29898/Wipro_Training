package tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class mulUnit {

	@Test
	public void test() {
		UnitTesting obj1 = new UnitTesting();
		int output_f=obj1.mul(4,5);
		assertEquals(20,output_f);
	}

}
