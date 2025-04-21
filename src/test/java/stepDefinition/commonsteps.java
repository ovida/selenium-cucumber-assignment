package stepDefinition;

import io.cucumber.java.en.When;
import utility.CommonStepsUtil;

public class commonsteps {

	@When("the user clicks on {string} button")
	public void the_user_clicks_on_button(String buttonName) {
	    CommonStepsUtil.clickButtonByName(buttonName);
	  
	}
}
