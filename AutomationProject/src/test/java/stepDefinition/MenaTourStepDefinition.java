package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MenaTourStepDefinition extends BaseStepDefinition {
	
	@Given("^Mena tour portal is open$")
	public void mena_tour_portal_is_open() throws Exception {
	    driver.get("https://menatour.golf/");
	}

	@When("^User navigates to News section$")
	public void user_navigates_to_News_section() throws Exception {
	   driver.findElement(By.xpath("(//a[contains(@href,'/news')])[1]")).click();
	}

	@Then("^the latest news on Mena tour is displayed$")
	public void the_latest_news_on_Mena_tour_is_displayed() throws Exception {
	    List<WebElement> allNews=driver.findElements(By.xpath("//*[@class='text-content']"));
	    
	    for(int i=0;i<allNews.size();i++)
	    {
	    	System.out.println(allNews.get(i).getText());
	    	System.out.println("-------------------------------------------------------");
	    }
	}



}
