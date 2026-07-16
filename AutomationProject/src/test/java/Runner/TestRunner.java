package Runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepDefinition", "hook"},
    tags = "@nagpuruniversity",
    dryRun = false,
    plugin = {
        "pretty",
        "json:target/cucumber.json",   // ✅ safer subfolder
        "html:target/cucumber-html-reports.html"
    },
    monochrome = true,
    publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    
//	@Override
//	@DataProvider(parallel=true)
//	public Object[][] scenarios()
//	{
//		return super.scenarios();
//	}
	
	//Uncomment above for parallel run, also update BaseStepDefinition to user ThreadLocal for WebDriver, WebDriverWait, Actions and JavascriptExecutor and update step definitions accordingly
}
