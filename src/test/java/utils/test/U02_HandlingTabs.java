package utils.test;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import page.P02_TabsWindowsPage;

public class U02_HandlingTabs extends BaseTest {

	@Test
	public void switchToTab() throws InterruptedException {

		P02_TabsWindowsPage tabsPage = new P02_TabsWindowsPage(driver);
		driver.get("https://demoqa.com/browser-windows");

		tabsPage.clickNewTabButton();
		//extentTest.info("Clicked on new tab button");
		Set<String> tabs = driver.getWindowHandles();
		String currentTab = driver.getWindowHandle();
		Iterator<String> itr = tabs.iterator();
		while (itr.hasNext()) {
			if (!itr.equals(currentTab)) {
				driver.switchTo().window(itr.next());
				//extentTest.info("Switched to the other tab");
				Thread.sleep(3000);
				System.out.println(driver.getTitle());
				Thread.sleep(3000);
				// driver.close();
			}
		}
		driver.switchTo().window(currentTab);
		//extentTest.info("Switched to the main tab");
		driver.navigate().refresh();
		//extentTest.info("Refreshed again.");
		System.out.println("Printing page title after returning. < " + driver.getTitle() + " >");

	}

	@Test
	public void switchToWindow() throws InterruptedException {

		P02_TabsWindowsPage tabsPage = new P02_TabsWindowsPage(driver);
		driver.get("https://demoqa.com/browser-windows");
		Thread.sleep(3000);
		
		tabsPage.clickNewWindowButton();
		//extentTest.info("Clicked on new windows button.");

		String currentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();

		Iterator<String> itr2 = windows.iterator();

		while (itr2.hasNext()) {
			if (!itr2.equals(currentWindow)) {

				driver.switchTo().window(itr2.next());
				//extentTest.info("SWitched to another windows.");
				Thread.sleep(3000);
			}
		}
		driver.switchTo().window(currentWindow);
		//extentTest.info("SWitched back to main windows.");
	}

	@Test
	public void switchToAlert() throws InterruptedException {

		P02_TabsWindowsPage tabsPage = new P02_TabsWindowsPage(driver);
		driver.get("https://demoqa.com/alerts");
		Thread.sleep(3000);
		
		tabsPage.acceptAlert();
		//extentTest.info("Alert accepted.");
		tabsPage.dismissAlert();
		//extentTest.info("Dismissed the alert");
		tabsPage.promptAlert();
		//extentTest.info("Prompt alert.");
		Assert.assertEquals(false, true);
	}
}
