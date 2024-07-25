package utils.test;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class U06_ExtentTest {
	
	
	@Test(priority=1)
	public void extentTest1() {
		Assert.assertEquals(true, true);
		
	}
	
	@Test(priority=2)
	public void extentTest2() {
		Assert.fail("Failing this test for testing.");
		
	}
	
	@Test(priority=3)
	public void extentTest3() {
		
		throw new SkipException("Skipping this test for testing..");
	}
	
	@Test(priority=4)
	public void extentTest4() {
		Assert.assertEquals(true, true);
		
	}

}
