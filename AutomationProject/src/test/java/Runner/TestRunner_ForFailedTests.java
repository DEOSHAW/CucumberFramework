package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "@target/failed_scenarios.txt",
        glue = "stepDefinitions",

        plugin = {
                "pretty",
                "json:target/failed_tests.json",
                "html:target/failed-tests-html-report"
        },

        monochrome = true
)
public class TestRunner_ForFailedTests extends AbstractTestNGCucumberTests {

}