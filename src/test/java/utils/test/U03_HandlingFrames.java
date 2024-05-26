package utils.test;

import org.testng.annotations.Test;

import base.BaseTest;
import page.P03_FramesPage;

public class U03_HandlingFrames extends BaseTest{
	
	@Test
	public void switchToFrames() throws InterruptedException {
		
		P03_FramesPage fp = new P03_FramesPage(driver);
		driver.get("https://demoqa.com/frames");
		
		System.out.println("This text is from frame 1- < "+fp.switchToFrame1()+" >");
		driver.switchTo().defaultContent();
		System.out.println("******");
		System.out.println("This text is from frame 2- < "+fp.switchToFrame2()+" >");
		driver.switchTo().defaultContent();
	}
	
	@Test
	public void switchToInnerFrames() throws InterruptedException {
		
		P03_FramesPage fp = new P03_FramesPage(driver);
		driver.get("https://demoqa.com/nestedframes");
		
		System.out.println("This text is from frame 1- < "+fp.switchToParentFrame()+" >");
		System.out.println("******");
		System.out.println("This text is from frame 2- < "+fp.swithcToNestedFrame()+" >");
		driver.switchTo().defaultContent();
	}
	
	
	
	
}
