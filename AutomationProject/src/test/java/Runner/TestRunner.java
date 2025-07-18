package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
 features = "Features",tags= "@lpu",
 glue={"stepDefinition","hook"},
 dryRun=false,
 monochrome=true,
 plugin = { "pretty", "html:target/cucumber-reports","json:target/cucumber.json","rerun:Features/rerun.txt" }
 )
public class TestRunner 
{
			
}
