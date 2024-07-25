package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseTest;

public class Screenshot extends BaseTest {
	
	public void takeScreenshot() throws IOException, InterruptedException {
        
		Thread.sleep(10000);
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("C:\\Users\\Nexus Lite\\eclipse-workspace\\nexus-ui\\results\\screenshots\\scr.png"));
	}

}
