package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UITPTextStepDefinition extends BaseStepDefinition {
	WebElement textBox,button;
	@Given("^UITP_Text_Input portal is open$")
	public void uitp_text_input_portal_is_open() throws Exception {
	    driver.get("http://uitestingplayground.com/textinput");
	}

	@When("^User pastes the text in textbox$")
	public void user_pastes_the_text_in_textbox() throws Exception {
		textBox=driver.findElement(By.xpath("//*[@placeHolder='MyButton']"));
		button= driver.findElement(By.xpath("(//*[@type='button'])[2]"));
	    js.executeScript("arguments[0].value=arguments[1]",textBox,"newButtonName");
	    Thread.sleep(500);
	    button.click();
	}

	@Then("^button name should not change$")
	public void button_name_should_not_change() throws Exception {
	   String buttonText=button.getText();
	   System.out.println("Button name is: "+buttonText);
	   Assert.assertEquals(buttonText, "Button That Should Change it's Name Based on Input Value");
	}

	@When("^User types the text in textbox$")
	public void user_types_the_text_in_textbox() throws Exception {
		textBox.clear();
		Thread.sleep(1000);
		textBox.sendKeys("newButtonName");
		button.click();
		Thread.sleep(500);
	}

	@Then("^button name should get updated$")
	public void button_name_should_get_updated() throws Exception {
		String buttonText=button.getText();
		 System.out.println("Button name is: "+buttonText);
		   Assert.assertEquals(buttonText, "newButtonName");
		   Thread.sleep(2000);
	}



}
