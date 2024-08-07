package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	By usernameField = By.id("text-auth-email");
	By passwordField = By.id("text-auth-password");
	By loginButton   = By.id("btn-auth-login");
	By accountLink   = By.xpath("//span[contains(text(),'sandipthopate1414+test@gmail.com')]");
	By signOutLink   = By.xpath("//a[text()='Sign out']");
	
	public void enterUserName(String uname) {
		
		driver.findElement(usernameField).sendKeys(uname);
	}
	
	public void enterPassword(String pwd) {
		
		driver.findElement(passwordField).sendKeys(pwd);
	}
	
	public void clickLoginButton() {
		
		driver.findElement(loginButton).click();
	}
	
	public void clickAccountProfile() {
		
		driver.findElement(accountLink).click();
	}
	
	public void clickLogoutLink() {
		
		driver.findElement(signOutLink).click();
	}
	
}
