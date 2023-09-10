package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;






@RunWith(Cucumber.class)
@CucumberOptions(
 //features = "Features",tags= {"@amazonFeature,@testFeature,@Guru99Feature,@seleniumEasyFeature","@roboFeature","@vaishnodeviFeature","@postmanFeature","QRFeature",@worksoftFeature,"@webTableFeature","@GitHub"},
//features = "Features",tags= {"@email,@worksoftFeature"},
features = {"@Features/rerun.txt"},
 glue={"stepDefinition","hook"},
 monochrome=true,
 plugin = { "pretty", "html:target/cucumber-reports","rerun:Features/rerun.txt" }
 )
public class TestRunner_ForFailedTests {
	
	
	

}
