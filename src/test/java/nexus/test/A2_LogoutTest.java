package nexus.test;

import org.testng.annotations.Test;

import base.BaseTest;
import page.LoginPage;

public class A2_LogoutTest extends BaseTest{
	
	@Test
	public void logout_Test() throws InterruptedException {
		
		LoginPage login = new LoginPage(driver);
		driver.get("https://cp.sync.com");
		
		login.enterUserName("sandipthopate1414+test@gmail.com");
		Thread.sleep(2000);
		//extentTest.info("Entered Email id");
		login.enterPassword("asdf1234");
		Thread.sleep(2000);
		//extentTest.info("Entered password id");
		login.clickLoginButton();
		Thread.sleep(2000);
		//extentTest.info("Clicked on submit button.");
		login.clickAccountProfile();
		Thread.sleep(2000);
		login.clickLogoutLink();
		
		Thread.sleep(10000);
	}

}
