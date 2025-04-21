package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {
           // "src/test/resources/features/login.feature",
            "src/test/resources/features/productPage.feature",
    		//"src/test/resources/features/checkoutPage.feature"
    },
    glue = {"stepDefinition", "utility"} ,
    plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"}
    )

public class TestRunner {

}
