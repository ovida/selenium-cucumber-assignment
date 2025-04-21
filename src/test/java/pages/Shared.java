package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.BrowserDriver;

public class Shared {

WebDriver driver;
	
	public Shared() {
		BrowserDriver.initializeDriver();
		driver = BrowserDriver.getDriver();
	}
	
	By usernameField = By.id("user-name");
	By passwordField = By.id("password");
	By loginButton = By.id("login-button");
	
	
}
