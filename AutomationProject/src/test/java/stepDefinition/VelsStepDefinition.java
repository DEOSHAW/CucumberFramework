package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VelsStepDefinition extends BaseStepDefinition
{
	@Given("Vels university portal is open")
	public void vels_university_portal_is_open() 
	{
	    driver.get("https://vistas.ac.in/");
	    driver.findElements(By.cssSelector("img.sgpb-popup-close-button-1")).get(0).click();
	}
	@When("User navigates to About Us page")
	public void user_navigates_to_about_us_page()
	{
	    WebElement aboutUs=driver.findElement(By.xpath("//span[text()='About Us']"));
	    WebElement overviewLink=driver.findElement(By.xpath("//span[text()='Overview']"));
	    actions.moveToElement(aboutUs).pause(Duration.ofSeconds(2)).click(overviewLink).perform();
	}
	@Then("Vels history text is displayed")
	public void vels_history_text_is_displayed() throws InterruptedException
	{
		WebElement aboutUsHeading=driver.findElement(By.cssSelector("h2.cmsmasters_heading"));
		js.executeScript("arguments[0].scrollIntoView();", aboutUsHeading);
		WebElement textElement=driver.findElement(By.xpath("//div[@class='cmsmasters_text']"));
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", textElement);
		Thread.sleep(3000);
	    
	}




}
