//package hooks;
//
//import io.qameta.allure.Allure;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//
//public class AllureCucumberHooks {
//
//    @Before
//    public void beforeScenario(Scenario scenario) {
//        // You can log some scenario details here before execution
//        System.out.println("Starting scenario: " + scenario.getName());
//    }
//
//    @After
//    public void afterScenario(Scenario scenario) {
//        // This is where Allure can add test result status (PASS/FAIL)
//        if (scenario.isFailed()) {
//            Allure.addAttachment("Failed", "Scenario failed");
//        } else {
//            Allure.addAttachment("Passed", "Scenario passed");
//        }
//        System.out.println("Finished scenario: " + scenario.getStatus());
//    }
//}
