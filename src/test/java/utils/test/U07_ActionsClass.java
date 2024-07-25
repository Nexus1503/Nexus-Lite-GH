package utils.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class U07_ActionsClass extends BaseTest{
	
	By clickMeButton = By.xpath("//button[text()='Click Me']");
	By dynamicClickMessage = By.xpath("//p[@id='dynamicClickMessage']");
	
	By rightClickMeButton = By.xpath("//button[@id='rightClickBtn']");
	
	By doubleClickMeButton = By.xpath("//button[@id='doubleClickBtn']");
	By doubleClickMessage = By.xpath("//p[@id='doubleClickMessage']");
	
	
	Actions actions;
	
	@Test
	public void actionsClick() {
		actions = new Actions(driver);
		
		driver.get("https://demoqa.com/buttons");
		actions.click(driver.findElement(clickMeButton)).perform();
		System.out.println(driver.findElement(dynamicClickMessage).getText());
		Assert.assertEquals(driver.findElement(dynamicClickMessage).getText(), "You have done a dynamic click");
		
	}
	
	@Test
	public void rightClick() {
		actions = new Actions(driver);
		
		driver.get("https://demoqa.com/buttons");
		actions.doubleClick(driver.findElement(doubleClickMeButton)).perform();
		System.out.println(driver.findElement(doubleClickMessage).getText());
		Assert.assertEquals(driver.findElement(doubleClickMessage).getText(), "You have done a double click");
		
	}
}
