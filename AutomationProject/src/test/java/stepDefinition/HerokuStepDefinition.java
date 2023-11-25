package stepDefinition;

import org.openqa.selenium.By;
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




}
