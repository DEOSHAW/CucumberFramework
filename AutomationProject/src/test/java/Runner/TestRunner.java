package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepDefinition", "hook"},
    tags = "@abs",
    plugin = {
        "pretty",
        "json:target/cucumber-report/cucumber.json",   // ✅ safer subfolder
        "html:target/cucumber-html-report"
    },
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    // no extra code needed, TestNG + Cucumber handles execution
}
