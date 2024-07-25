package utils.test;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class U05_SeleniumWaits{
	
	
	WebDriver driver;
	WebDriverWait wait;
	FluentWait<WebDriver> fluentWait;
	SoftAssert softAssert= new SoftAssert();
	@Test
	public void implementExplicitWait() {
		
		// WebDriver initialization
		
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		// By locators.
		By usernameField = By.id("text-auth-email");
		By passwordField = By.id("text-auth-password");
		By loginButton   = By.id("btn-auth-login");
		By loggedInUser = By.xpath("//span[contains(text(),'sandipthopate1414+test@gmail.com ')]");
		
		//User Actions with Explicit Waits.
		driver.get("https://cp.sync.com");
		explicitWaitType(usernameField, "sandipthopate1414+test@gmail.com");
		explicitWaitType(passwordField, "asdf1234");
		explicitWaitClick(loginButton);
		softAsserts(explicitWaitIsVisbile(loggedInUser), "abcd" );
		driver.quit();
	}
	
	@Test
	public void implementFluentWait() {
		
		// WebDriver initialization
		
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		// By locators.
		By usernameField = By.id("text-auth-email");
		By passwordField = By.id("text-auth-password");
		By loginButton   = By.id("btn-auth-login");
		By loggedInUser = By.xpath("//span[contains(text(),'sandipthopate1414+test@gmail.com ')]");
		
		//User Actions with Explicit Waits.
		driver.get("https://cp.sync.com");
		fluentWaitType(usernameField, "sandipthopate1414+test@gmail.com");
		fluentWaitType(passwordField, "asdf1234");
		fluentWaitClick(loginButton);
		System.out.println(fluentIsVisible(loggedInUser)); 
		Assert.assertEquals(fluentIsVisible(loggedInUser), "sandipthopate1414+test@gmail.com");

		driver.quit();
	}

	private void fluentWaitClick(By button) {
		fluentWait = new FluentWait<WebDriver>(driver);
		WebElement ele = fluentWait.pollingEvery(Duration.ofSeconds(2)).withTimeout(Duration.ofSeconds(30)).ignoring(TimeoutException.class).until(ExpectedConditions.elementToBeClickable(button));
		ele.click();
	}

	private void fluentWaitType(By byLocator, String string) {
		fluentWait = new FluentWait<WebDriver>(driver);
		WebElement ele = fluentWait.pollingEvery(Duration.ofSeconds(2)).withTimeout(Duration.ofSeconds(30)).ignoring(TimeoutException.class).until(ExpectedConditions.elementToBeClickable(byLocator));
		ele.clear();
		ele.sendKeys(string);
	}
	
	private String fluentIsVisible(By visibleElement) {
		fluentWait = new FluentWait<WebDriver>(driver);
		WebElement ele = fluentWait.pollingEvery(Duration.ofSeconds(2)).withTimeout(Duration.ofSeconds(30)).ignoring(TimeoutException.class).until(ExpectedConditions.visibilityOfElementLocated(visibleElement));
		return ele.getText();
	}

	public void explicitWaitType(By by, String value) {
		try {
		WebElement typableElement = wait.until(ExpectedConditions.elementToBeClickable(by));
		typableElement.clear();
		typableElement.sendKeys(value);
		}catch(Exception e) {
			System.out.println("Cannot type to the given elementm, please check error here.");
			e.printStackTrace();
		}
	}

	public void explicitWaitClick(By by) {
		try{
			WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(by));
		clickableElement.click();
		}catch(Exception e) {
			System.out.println("Cannot click on the element. please check error here.");
			e.printStackTrace();
		}
	}
	
	public String explicitWaitIsVisbile(By by) {
		try{
			WebElement visibleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			return visibleElement.getText();
		}catch(Exception e) {
			System.out.println("Element cannot be visible. please check error here.");
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void softAsserts(String str1, String str2) {
		
		try{ 
			softAssert.assertEquals(str1, str2);
		}catch(Exception e) {
		System.out.println("Some exception occured, please check below."+e);
	}
		
		
	}
}
