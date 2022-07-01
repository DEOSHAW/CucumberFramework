package stepDefinition;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InfosysStepDefinition extends BaseStepDefinition {
	
	@Given("^Infosys portal is open$")
	public void infosys_portal_is_open() throws Exception {
	    driver.get("https://www.infosys.com/");
	}

	@When("^user navigates to Infosys portal page$")
	public void user_navigates_to_Infosys_portal_page() throws Exception {
	   driver.findElement(By.xpath("//*[@class='burger']")).click();
	   driver.findElement(By.xpath("//*[@class='platforms']")).click();
	}

	@Then("^the list of portals is displayed$")
	public void the_list_of_portals_is_displayed() throws Exception {
	   List<WebElement> platformsList= driver.findElements(By.xpath("//*[@class='platforms-menu wow animated fadeInLeftBig']//li/a"));
	   
	   Iterator<WebElement> itr=platformsList.iterator();
	   StringBuilder Platforms=new StringBuilder();
	   while(itr.hasNext())
	   {
		   Platforms.append(itr.next().getText());
		   Platforms.append("\n");
	   }
	   
	   js.executeScript("alert(arguments[0])", Platforms.toString());
	   Thread.sleep(2500);
	   driver.switchTo().alert().accept();
	   Thread.sleep(1000);
	}


	

}
