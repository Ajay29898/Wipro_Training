package tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class ddwithlargnoUnit {

	@Test
	public void test() {
		UnitTesting obj1 = new UnitTesting();
		int output_f=obj1.addwithlargno(4,500000);
		assertEquals(500004,output_f);
	}

}
