package utilities;

import org.openqa.selenium.By;

import base.BaseTest;

public class UserActions extends BaseTest {

	public void userType(By by, String value) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(value);
	}

	public void userClick(By by) {
		driver.findElement(by).click();
	}
}
