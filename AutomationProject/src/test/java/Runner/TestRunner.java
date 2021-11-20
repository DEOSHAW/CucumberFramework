package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
 //features = "Features",tags= {"@amazonFeature,@testFeature,@Guru99Feature,@seleniumEasyFeature","@roboFeature","@vaishnodeviFeature","@postmanFeature","QRFeature",@worksoftFeature,"@webTableFeature","@GitHub"},
//features = "Features",tags= {"@email,@worksoftFeature"},
features = "Features",tags= {"@graphql"},
 glue={"stepDefinition","hook"},
 monochrome=true,
 plugin = { "pretty", "html:target/cucumber-reports","rerun:Features/rerun.txt" }
 )
public class TestRunner {
	
	
	

}
