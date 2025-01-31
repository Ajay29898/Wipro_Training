package tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class addwithzeroUnit {

	@Test
	public void test() {
		UnitTesting obj1 = new UnitTesting();
		int output_f=obj1.addwithzero(4,0);
		assertEquals(4,output_f);
	}

}
