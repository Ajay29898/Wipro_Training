package tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class modUnit {

	@Test
	public void test() {
		UnitTesting obj1 = new UnitTesting();
		int output_f=obj1.mod(10,5);
		assertEquals(0,output_f);
	}

}
