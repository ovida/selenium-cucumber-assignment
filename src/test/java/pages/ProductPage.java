package pages;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import utility.BrowserDriver;

public class ProductPage extends Shared {
	
	//WebDriver driver;
	
	//public ProductPage() {

	//	 driver = BrowserDriver.getDriver();
	//}
	
	
	public String getCurrentUrl() {
		
		return driver.getCurrentUrl();
			
	}
	
	public void verifyTitle(String expectedTitle) {
		
		WebElement actualTitleElement = driver.findElement(By.xpath("//div[@class='app_logo']"));
		
		String actualTitle = actualTitleElement.getText();
		if (!actualTitle.contains(expectedTitle)) {
			throw new AssertionError("Title does not match. Expected: " + expectedTitle + ", Actual: " + actualTitle);
		}
	}
	
public void verifyTitle() {
		
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		WebElement actualTitleElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='inventory_details_name large_size']")));
	WebElement actualTitleElement = wait.until(ExpectedConditions.elementToBeClickable(By.className("inventory_item_name")));
		String actualTitle = actualTitleElement.getText();
		if (!actualTitle.contains("Sauce Labs Backpack")) {
			throw new AssertionError("Title does not match. Expected: Sauce Labs Backpack, Actual: " + actualTitle);
		}
	}
	
public void verifySubTitle(String expectedTitle) {
		
		WebElement actualTitleElement = driver.findElement(By.xpath("//span[text()='" + expectedTitle + "']"));
		
		String actualTitle = actualTitleElement.getText();
		if (!actualTitle.contains(expectedTitle)) {
			throw new AssertionError("Title does not match. Expected: " + expectedTitle + ", Actual: " + actualTitle);
		}
	}

public void clickOn(String btnName) {
	try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='" + btnName + "']")));
		addToCartButton.click();
	} catch (Exception e) {
		System.out.println("Add to cart button not found: " + e.getMessage());
	}
}
public void clickOnById(String btnName) {
	try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(btnName)));
		addToCartButton.click();
	} catch (Exception e) {
		System.out.println("Add to cart button not found: " + e.getMessage());
	}
}

	public void clickAddToCartButton() {
	try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='add-to-cart-sauce-labs-bike-light'])[1]")));
		addToCartButton.click();
	} catch (Exception e) {
		System.out.println("Add to cart button not found: " + e.getMessage());
	}
}
	
	public void goToCart() throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(By.id("shopping_cart_container")));
	    cartIcon.click();
//	    
	    
	}
	
	public void cartUpdated() {
		String xpath = "//span[@class='shopping_cart_badge']";

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

		assertTrue("Cart is not updated", element.isDisplayed());
	}


	public void verifyCart(String string) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(string)));
		
		assertTrue("Cart is not displayed", element.isDisplayed());
	}

	public void verifyCartEmpty(String cssSelector) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		 
		List<WebElement> elements = driver.findElements(By.cssSelector(cssSelector));
		
		boolean isNotDisplayed = elements.isEmpty() || !elements.get(0).isDisplayed();
		
		 assertTrue("Cart is NOT empty – element is still displayed", isNotDisplayed);
	
	}
	
	public void logout() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-menu-btn")));
		menuButton.click();

		WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
		logoutButton.click();

		System.out.println("User logged out successfully.");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.navigate().refresh();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}
