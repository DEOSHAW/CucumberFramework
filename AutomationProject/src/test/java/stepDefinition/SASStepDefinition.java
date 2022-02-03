package stepDefinition;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.locators.RelativeLocator;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SASStepDefinition extends BaseStepDefinition {
	WebElement demoTrialLink;
	@Given("^SAS portal is launched$")
	public void sas_portal_is_launched() throws Exception {
	    driver.get("https://www.sas.com/en_in/home.html");
	}

	@When("^user scrolls down to demo section$")
	public void user_scrolls_down_to_demo_section() throws Exception {
	    demoTrialLink=driver.findElement(By.xpath("(//*[@class='small-txt-light'])[4]"));
	    js.executeScript("arguments[0].scrollIntoView();", demoTrialLink);
	    Thread.sleep(2000);
	}

	@Then("^the demo information is displayed$")
	public void the_demo_information_is_displayed() throws Exception {
		String textInfo=demoTrialLink.getText();
		File src=demoTrialLink.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File(System.getProperty("user.dir")+File.separator+"SASINC.png"));
		System.out.println(textInfo);
	    
	}


}
