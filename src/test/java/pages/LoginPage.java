package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.BrowserDriver;

public class LoginPage extends Shared {
	
	
	public void launchLoginPage(String url) {
		driver.get(url);
	}
	
	public void enterUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickButton() {
		driver.findElement(loginButton).click();
	}
	
	public boolean verifyMessage(String message) {
		try {
			driver.findElement(By.xpath("//*[contains(text(), '" + message + "')]"));
		}
		catch (NoSuchElementException e) {
			System.out.println("Message not found: " + message);
			return false;
		}
return true;			
	}

	
}
