package tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class subUnit {

	@Test
	public void test() {
		UnitTesting obj1 = new UnitTesting();
		int output_f=obj1.sub(4,5);
		assertEquals(-1,output_f);
	}

}
