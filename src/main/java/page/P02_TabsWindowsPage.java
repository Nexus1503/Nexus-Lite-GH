package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P02_TabsWindowsPage {

	WebDriver driver;

	public P02_TabsWindowsPage(WebDriver driver) {
		this.driver = driver;
	}

	By newTabButton = By.id("tabButton");
	By newWindowButton = By.id("windowButton");
	By newWindowsMessageButton = By.id("messageWindowButton");

	// By tabText = By.xpath("//h1[@id='sampleHeading']");

	By simpleAlert = By.id("alertButton");
	By confirmAlert = By.id("confirmButton");
	By promptAlert = By.id("promtButton");
	
	public void clickNewTabButton() {

		driver.findElement(newTabButton).click();
	}

	public void clickNewWindowButton() {

		driver.findElement(newWindowButton).click();
	}

	public void clickNewWindowMessageButton() {

		driver.findElement(newWindowsMessageButton).click();
	}

	public String getTabText() {

		WebElement newTabText = driver.findElement(By.id("sampleHeading"));

		return newTabText.getText();
	}

	public void acceptAlert() throws InterruptedException {

		driver.findElement(simpleAlert).click();
		Alert simpleAlert = driver.switchTo().alert();
		Thread.sleep(5000);
		simpleAlert.accept();

	}

	public void dismissAlert() throws InterruptedException {

		driver.findElement(confirmAlert).click();
		Alert simpleAlert = driver.switchTo().alert();
		Thread.sleep(5000);
		simpleAlert.accept();
	}
	
	public void promptAlert() throws InterruptedException {
		
		driver.findElement(promptAlert).click();
		Alert simpleAlert = driver.switchTo().alert();
		Thread.sleep(2000);
		simpleAlert.sendKeys("hey alert");
		Thread.sleep(2000);
		simpleAlert.accept();
	}
}
