package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ addwithzeroUnit.class, ddwithlargnoUnit.class, divUnit.class, modUnit.class, mulUnit.class,
		squareUnit.class, subUnit.class, sumUnit.class })
public class AllTests {

}
