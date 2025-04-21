package utility;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserDriver {

	private static WebDriver driver;
	
	public static void initializeDriver() {
		if (driver == null) {
	
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions options = new ChromeOptions();

	        // ✅ Disable the password manager popup
	        Map<String, Object> prefs = new HashMap<>();
	        prefs.put("credentials_enable_service", false);
	        prefs.put("profile.password_manager_enabled", false);
	        prefs.put("autofill.profile_enabled", false);
	        options.setExperimentalOption("prefs", prefs);

	        // ✅ Optional: other nice settings
	        options.addArguments("--disable-blink-features=AutomationControlled");
	        options.addArguments("--disable-infobars");
	        options.addArguments("--disable-save-password-bubble");

	        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
	        options.addArguments("--incognito");
	        
			driver = new ChromeDriver(options);
	}
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	
	
	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
	public static void clickButton(String selector) {

		WebElement addToCartButton = driver.findElement(By.cssSelector(selector));
		addToCartButton.click();
	}
}


