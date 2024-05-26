package utils.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import base.BaseTest;

/*
 * File : is a class from java.io
 * TakesScreenshot is interface, RemoteWebDriver implements it. 
 * The only method this interface has is getScreenshotAs method. it is located in org.openqa.selenium.remote package.
 * FileUtils is a class from commons.io, 
 */


public class Utility_Screenshot extends BaseTest {

	@Test
	public void takeScreenshot() throws IOException, InterruptedException {
		                
		Thread.sleep(10000);
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("C:\\Users\\Nexus Lite\\eclipse-workspace\\nexus-ui\\results\\screenshots\\scr.png"));
	}

}
  