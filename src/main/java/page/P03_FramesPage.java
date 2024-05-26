package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_FramesPage {

	WebDriver driver;

	public P03_FramesPage(WebDriver driver) {
		this.driver = driver;
	}

	By frame1 = By.id("frame1");
	By textFrame1 = By.xpath("//h1[@id='sampleHeading']");

	By frame2 = By.id("frame2");
	By textFrame2 = By.xpath("//h1[@id='sampleHeading']");
	
	
	// For nested frames..
	
	By parentFrame = By.xpath("//body[text()='Parent frame']");
	By nestedFrame = By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']");
	By textNestedFram = By.xpath("//p[text()='Child Iframe']");
	

	public String switchToFrame1() {

		driver.switchTo().frame("frame1");
		return driver.findElement(textFrame1).getText();
	}

	public String switchToFrame2() {

		driver.switchTo().frame("frame2");
		return driver.findElement(textFrame2).getText();
	}
	
	public String switchToParentFrame() {
		driver.switchTo().frame(driver.findElement(frame1));
		return driver.findElement(parentFrame).getText();
	}
	
	public String swithcToNestedFrame() {
		
		driver.switchTo().frame(driver.findElement(nestedFrame));
		return driver.findElement(textNestedFram).getText();
	}
}
