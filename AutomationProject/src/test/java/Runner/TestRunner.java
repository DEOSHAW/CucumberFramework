package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
 //features = "Features",tags= {"@amazonFeature,@testFeature,@Guru99Feature,@seleniumEasyFeature","@roboFeature","@vaishnodeviFeature","@postmanFeature","QRFeature",@worksoftFeature},
features = "Features",tags= {"@worksoftFeature,@amazonFeature"},
 glue={"stepDefinition"},
 plugin = { "pretty", "html:target/cucumber-reports" }
 )
public class TestRunner {
	
	
	

}
