package utility;

import java.util.Map;

public class CommonStepsUtil {
	
	static Map<String, String> specialSelectors = Map.of("Remove", "#remove-sauce-labs-bike-light");
	
	 public static void clickButtonByName(String buttonName) {
	        String selector = getButtonSelector(buttonName);
	        BrowserDriver.clickButton(selector);
	    }

	    private static String getButtonSelector(String buttonName) {
	    	if (specialSelectors.containsKey(buttonName)) {
	    		return specialSelectors.get(buttonName);
	    	}
	    	return "#"+buttonName.toLowerCase().replace(" ", "-");
	    }
	}

