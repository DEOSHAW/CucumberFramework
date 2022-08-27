package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AccionLabsStepDefinition extends BaseStepDefinition {
	
	@Given("^Accion labs portal is open$")
	public void accion_labs_portal_is_open() throws Exception {
	    driver.get("https://www.accionlabs.com/");
	}

	@When("^user finds the names of trusted partners$")
	public void user_finds_the_names_of_trusted_partners() throws Exception {
	    WebElement partnerText=driver.findElement(By.xpath("//*[contains(text(),'Trusted Partner To Global Brands')]"));
	    js.executeScript("arguments[0].scrollIntoView();", partnerText);
	}

	@Then("^the list of partners is displayed$")
	public void the_list_of_partners_is_displayed() throws Exception {
		
		List<WebElement> partnerBrands=driver.findElements(By.xpath("//app-logo-list//img"));
		
		for(WebElement brand:partnerBrands)
		{
			System.out.println(brand.getAttribute("alt"));
			
		}
	    
	}


}
