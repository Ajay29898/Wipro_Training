package tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class divUnit {

	@Test
	public void test() {
		UnitTesting obj1 = new UnitTesting();
		int output_f=obj1.div(4,2);
		assertEquals(2,output_f);
	}

}
