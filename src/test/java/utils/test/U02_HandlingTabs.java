package utils.test;

import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.Test;

import base.BaseTest;
import page.P02_TabsWindowsPage;

public class U02_HandlingTabs extends BaseTest {

	@Test
	public void switchToTab() throws InterruptedException {

		P02_TabsWindowsPage tabsPage = new P02_TabsWindowsPage(driver);
		driver.get("https://demoqa.com/browser-windows");

		tabsPage.clickNewTabButton();
		Set<String> tabs = driver.getWindowHandles();
		String currentTab = driver.getWindowHandle();
		Iterator<String> itr = tabs.iterator();
		while (itr.hasNext()) {
			if (!itr.equals(currentTab)) {
				driver.switchTo().window(itr.next());
				Thread.sleep(3000);
				System.out.println(driver.getTitle());
				Thread.sleep(3000);
				// driver.close();
			}
		}
		driver.switchTo().window(currentTab);
		driver.navigate().refresh();
		System.out.println("Printing page title after returning. < " + driver.getTitle() + " >");

	}

	@Test
	public void switchToWindow() throws InterruptedException {

		P02_TabsWindowsPage tabsPage = new P02_TabsWindowsPage(driver);
		driver.get("https://demoqa.com/browser-windows");
		Thread.sleep(3000);
		
		tabsPage.clickNewWindowButton();

		String currentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();

		Iterator<String> itr2 = windows.iterator();

		while (itr2.hasNext()) {
			if (!itr2.equals(currentWindow)) {

				driver.switchTo().window(itr2.next());
				Thread.sleep(3000);
			}
		}
		driver.switchTo().window(currentWindow);

	}

	@Test
	public void switchToAlert() throws InterruptedException {

		P02_TabsWindowsPage tabsPage = new P02_TabsWindowsPage(driver);
		driver.get("https://demoqa.com/alerts");
		Thread.sleep(3000);
		
		tabsPage.acceptAlert();
		Thread.sleep(3000);
		
		tabsPage.dismissAlert();
		Thread.sleep(3000);
		
		tabsPage.promptAlert();
		Thread.sleep(3000);

	}
}
