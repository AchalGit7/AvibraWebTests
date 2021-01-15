package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

	@RunWith(CucumberWithSerenity.class)
	@CucumberOptions(features = "src/test/resources/", glue = "stepDefinitions", tags = "@ReimbursementClaim", junit = "--step-notifications")

	public class Runner {
	
	
}


