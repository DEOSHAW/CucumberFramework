package stepDefinition;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NextGenAIStepDefinition extends BaseStepDefinition {
	String alertText,confirmAlertText,promptText;
	
	@Given("NextGenAI alerts portal is open")
	public void next_gen_ai_alerts_portal_is_open() {
	    driver.get("https://nxtgenaiacademy.com/alertandpopup/");
	}
	@When("User clicks on buttons to generate portals and handles them")
	public void user_clicks_on_buttons_to_generate_portals_and_handles_them() throws InterruptedException {
		
		//Handle alert
		driver.findElement(By.xpath("//button[@name='alertbox']")).click();
		Alert alert=driver.switchTo().alert();
		alertText=alert.getText();
		Thread.sleep(2000);
		alert.accept();
		
		//Handle confirm alert
		driver.findElement(By.xpath("//button[@name='confirmalertbox']")).click();
		Alert alertConfirm=driver.switchTo().alert();
		confirmAlertText=alertConfirm.getText();
		Thread.sleep(2000);
		alertConfirm.accept();
		
		//Handle Prompt
		driver.findElement(By.xpath("//button[@name='promptalertbox1234']")).click();
		Alert prompt=driver.switchTo().alert();
		promptText=prompt.getText();
		Thread.sleep(3000);
		driver.switchTo().alert().sendKeys("Yes");
		Thread.sleep(2000);
		prompt.accept();
		
	    
	}
	@Then("the texts on the popup is captured")
	public void the_texts_on_the_popup_is_captured() {
	    System.out.println("Alert box text: "+alertText);
	    System.out.println("Confirm alert text: "+confirmAlertText);
	    System.out.println("Prompt text: "+promptText);
	}




}
