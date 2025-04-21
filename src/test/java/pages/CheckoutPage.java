package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;

public class CheckoutPage extends Shared {

	public void fillCheckoutForm(DataTable dataTable) {
	
	List<Map<String, String>> formData = dataTable.asMaps(String.class, String.class);
	Map<String, String> info = formData.get(0);
	
	 System.out.println("DEBUG: Form keys received: " + info.keySet());
	if (info.containsKey("First Name")) {
		enterFirstName(info.get("First Name"));
	}
	if (info.containsKey("Last Name")) {
		enterLastName(info.get("Last Name"));
	}
	if (info.containsKey("Zip/Postal Code")) {
		enterZipCode(info.get("Zip/Postal Code"));
	}

} 
	
public void enterFirstName(String firstName) {
	driver.findElement(By.id("first-name")).sendKeys(firstName);
}
	
public void enterLastName(String lastName) {
	driver.findElement(By.id("last-name")).sendKeys(lastName);
}

public void enterZipCode(String zipCode) {
	driver.findElement(By.id("postal-code")).sendKeys(zipCode);
}

public boolean isErrorMessageDisplayed(String expectedMessage) {
    String actualMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
    return actualMessage.equals(expectedMessage);
}

public String getConfirmationMessage() {
    return driver.findElement(By.className("complete-header")).getText();
}



}