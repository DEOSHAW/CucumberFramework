package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PWCStepDefinition extends BaseStepDefinition {
	
	static JavascriptExecutor js;
	static Actions actions;
	
	@Given("^PWC portal is launched$")
	public void pwc_portal_is_launched() throws Throwable {
	    driver.get("https://www.pwc.in/");
	    js=(JavascriptExecutor)driver;
	    actions=new Actions(driver);
	}

	@When("^user searches for \"([^\"]*)\" keyword$")
	public void user_searches_for_keyword(String searchTerm) throws Throwable {
        WebElement searchLink=driver.findElement(By.xpath("//*[@aria-label='Search']"));
	    js.executeScript("arguments[0].click();", searchLink);
	    WebElement searchBox=driver.findElement(By.xpath("//*[@placeholder='Search']"));
	    js.executeScript("arguments[0].value=arguments[1]", searchBox,searchTerm);
	    Thread.sleep(1000);
	    actions.sendKeys(Keys.ENTER).perform();
	    Thread.sleep(2500);
	    
	}

	@Then("^total number of job opportunities are displayed$")
	public void total_number_of_job_opportunities_are_displayed() throws Throwable {
		WebElement searchResult=driver.findElement(By.xpath("//strong[text()='Careers']/parent::h2"));
	    String searchResultValue=(String) js.executeScript("return arguments[0].innerHTML;", searchResult);
	    //84&nbsp;Results&nbsp;for <strong>Careers</strong>
	    System.out.println("Search result is: "+searchResultValue.replaceAll("&nbsp","").replaceAll("<strong>","").replaceAll("</strong>", "")
	    		.replaceAll(";", " "));
	}


}
