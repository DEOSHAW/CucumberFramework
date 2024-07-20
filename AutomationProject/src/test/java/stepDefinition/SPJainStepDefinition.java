package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SPJainStepDefinition extends BaseStepDefinition
{

@Given("SP Jain portal is open")
public void sp_jain_portal_is_open() {
    driver.get("https://www.spjimr.org/");
}
@When("User navigates to USP section")
public void user_navigates_to_usp_section() {
	WebElement SPJainUSP=driver.findElement(By.xpath("//span[text()='SPJIMR?']"));
	js.executeScript("arguments[0].scrollIntoView();", SPJainUSP);
	
}
@Then("USP of SP Jain is displayed")
public void usp_of_sp_jain_is_displayed() throws InterruptedException {
	String text=(String) js.executeScript("return arguments[0].innerHTML;", driver.findElement(By.xpath("//p[contains(text(),'SPJIMR is especially known')]")));
    System.out.println(text);
    Thread.sleep(1500);
    js.executeScript("alert(arguments[0])", text);
    Thread.sleep(2500);
    driver.switchTo().alert().accept();
    Thread.sleep(1000);
    
}
}
