package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReportLibrary;

public class BaseTest {
	
	public WebDriver driver;
	
	public ExtentReports extentReport = ReportLibrary.getReporter();
	public ExtentTest extentTest;
	public String methodName;
	
	@BeforeMethod
	protected void setUp() {
		
		
	
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
	}
	
	@AfterMethod
	protected void teadDown() {
		
		driver.quit();
	}
	@AfterSuite
	public void endSuite() {
	//	extentReport.flush();
	}
	
}
