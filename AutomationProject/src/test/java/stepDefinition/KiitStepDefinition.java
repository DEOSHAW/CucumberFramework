package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class KiitStepDefinition extends BaseStepDefinition
{
	@Given("KIIT university portal is open")
	public void kiit_university_portal_is_open() {
	    driver.get("https://kiit.ac.in/");
	}
	@When("User navigates to KIIT about page")
	public void user_navigates_to_kiit_about_page() 
	{
	    driver.findElement(By.xpath("(//span[@class='menu-text' and text()='ABOUT KIIT'])[1]")).click();
	    WebElement quickFacts=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Quick Facts']")));
	    js.executeScript("arguments[0].scrollIntoView();", quickFacts);
	}
	@Then("quick facts are highlighted")
	public void quick_facts_are_highlighted() throws InterruptedException
	{
	    List<WebElement> allQuickFacts=driver.findElements(By.xpath("//h2[@class='fusion-title-heading title-heading-center']/parent::div/parent::div"));
	    for(WebElement quickFact:allQuickFacts)
	    {
	    	js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", quickFact);
	    	Thread.sleep(1000);
	    }
	}


}
