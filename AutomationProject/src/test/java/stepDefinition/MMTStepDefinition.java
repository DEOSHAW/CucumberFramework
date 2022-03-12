package stepDefinition;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MMTStepDefinition extends BaseStepDefinition {
	List<WebElement> mmtServices;
	
	@Given("^MMT portal is launched$")
	public void mmt_portal_is_launched() throws Exception {
	   driver.get("https://www.makemytrip.com/");
	}

	@When("^user explores different offered services$")
	public void user_explores_different_offered_services() throws Exception {
		mmtServices= driver.findElements(By.xpath("//*[@class='chHeaderContainer']/child::nav/ul/li"));
	}

	@Then("^list of MMT services is displayed$")
	public void list_of_MMT_services_is_displayed() throws Exception {
		
	   
		for(WebElement Service:mmtServices)
		{
			Date date=new Date();
			SimpleDateFormat format=new SimpleDateFormat("mm:HH:SS");
			
			
			System.out.println(Service.getAttribute("data-cy").replaceAll("menu_", ""));
			File file=new File(System.getProperty("user.dir")+File.separator+"file_"+format.format(date).replaceAll(":", "_")+".jpeg");
			org.openqa.selenium.io.FileHandler.copy(Service.getScreenshotAs(OutputType.FILE), file);
			
		}
	}


}
