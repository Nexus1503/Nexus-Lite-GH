package nexus.test;

import org.testng.annotations.Test;

import base.BaseTest;
import page.LoginPage;

public class A1_LoginTest extends BaseTest {
	
	@Test
	public void login_with_correct_credentials() throws InterruptedException {
		
		LoginPage login = new LoginPage(driver);
		driver.get("https://cp.sync.com");
		
		login.enterUserName("sandipthopate1414+test@gmail.com");
		//extentTest.info("Entered Email id");
		login.enterPassword("asdf1234");
		//extentTest.info("Entered password id");
		login.clickLoginButton();
		//extentTest.info("Clicked on submit button.");
	}

}
