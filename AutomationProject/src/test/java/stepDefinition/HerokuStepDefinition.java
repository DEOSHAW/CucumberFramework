package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HerokuStepDefinition extends BaseStepDefinition{
	
	@Given("Heroku portal is open")
	public void heroku_portal_is_open() {
	    driver.get("https://the-internet.herokuapp.com/");
	}
	@When("User navigates to file upload page")
	public void user_navigates_to_file_upload_page() {
	  driver.findElement(By.xpath("//a[@href='/upload']")).click();
	}
	@When("User uploads a file")
	public void user_uploads_a_file() {
	   driver.findElement(By.cssSelector("#file-upload")).sendKeys("C:\\Users\\deosh\\Pictures\\Demo_Image.JPG");
	   driver.findElement(By.cssSelector("#file-submit")).click();
	}
	@Then("the file gets uploaded")
	public void the_file_gets_uploaded() throws InterruptedException {
	    String uploadedFileName=driver.findElement(By.cssSelector("#uploaded-files")).getText();
	    Thread.sleep(2000);
	    Assert.assertEquals(uploadedFileName, "Demo_Image.JPG");
	}
	
	@Given("Heroku dynamic content portal is open")
	public void heroku_dynamic_content_portal_is_open() {
	    driver.get("https://the-internet.herokuapp.com/dynamic_loading");
	}
	@When("User clicks on Second link")
	public void user_clicks_on_second_link() {
	    driver.findElement(By.xpath("//a[contains(text(),'Example 2')]")).click();
	}
	@When("User clicks on start button")
	public void user_clicks_on_start_button() {
		driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
	    
	}
	@Then("the dynamic content is displayed")
	public void the_dynamic_content_is_displayed() {
		
		WebElement dynamicallyLoadedElement= driver.findElement(By.cssSelector("#finish>h4"));
		String text=(String) js.executeScript("return arguments[0].innerHTML;", dynamicallyLoadedElement);
		
		System.out.println("Dynamically loaded content is: "+text);
		
	}
	
	@Given("Heroku frame page is open")
	public void heroku_frame_page_is_open() 
	{
	    driver.get("https://the-internet.herokuapp.com/nested_frames");
	}
	@When("user switches to middle frame")
	public void user_switches_to_middle_frame() 
	{
	    driver.switchTo().frame(0);
	    driver.switchTo().frame(1);
	    
	}
	@Then("middle text is highlighted")
	public void middle_text_is_highlighted() throws InterruptedException
	{
		WebElement textElement=driver.findElement(By.cssSelector("div#content"));
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", textElement);
		Thread.sleep(3000);
	    
	}
	
	@When("User user logs in with basic auth to heroku portal")
	public void user_user_logs_in_with_basic_auth_to_heroku_portal()
	{
	    driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
	}
	@Then("welcome message is displayed")
	public void welcome_message_is_displayed()
	{
	  Assert.assertEquals(driver.findElement(By.cssSelector("div.example>p")).getText(), "Congratulations! You must have the proper credentials.");
	    
	}
}
