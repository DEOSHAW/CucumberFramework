package stepDefinition;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MahindraStepDefinition extends BaseStepDefinition
{
	@Given("Mahindra portal is open")
	public void mahindra_portal_is_open() {
	    driver.get("https://www.mahindra.com/");
	}
	@When("User navigates to leadership page")
	public void user_navigates_to_leadership_page() {
		WebElement aboutUsLink=driver.findElement(By.xpath("//a[text()='about us']"));
		WebElement leadershipLink=driver.findElement(By.xpath("//a[text()='Leadership']"));
	    actions.moveToElement(aboutUsLink).pause(Duration.ofSeconds(1)).click(leadershipLink).build().perform();
	}
	@Then("picture is saved")
	public void picture_is_saved() throws IOException {
	  TakesScreenshot ts=(TakesScreenshot)driver;
	  File srcFile=ts.getScreenshotAs(OutputType.FILE);
	  File destFile=new File(System.getProperty("user.dir")+File.separator+"LeadershipImage.png");
	  FileHandler.copy(srcFile, destFile);
	}




}
