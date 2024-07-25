package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class ActionsLibrary extends BaseTest {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	
	public void type(By by, String value) {
		try {
		WebElement typableElement = wait.until(ExpectedConditions.elementToBeClickable(by));
		typableElement.clear();
		typableElement.sendKeys(value);
		}catch(Exception e) {
			System.out.println("Cannot type to the given elementm, please check error here.");
			e.printStackTrace();
		}
	}

	public void clickElement(By by) {
		try{
			WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(by));
		clickableElement.click();
		}catch(Exception e) {
			System.out.println("Cannot click on the element. please check error here.");
			e.printStackTrace();
		}
	}
}
