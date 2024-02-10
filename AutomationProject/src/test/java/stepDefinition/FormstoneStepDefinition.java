package stepDefinition;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FormstoneStepDefinition extends BaseStepDefinition 
{
	String fileToUpload;
	
	@Given("Formstone portal is open")
	public void formstone_portal_is_open() {
	   driver.get("https://formstone.it/components/upload/");
	}
	@When("User uploads below file")
	public void user_uploads_below_file(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	    List<Map<String,String>> dataList=dataTable.asMaps(String.class, String.class);
	    fileToUpload=dataList.get(0).get("fileName");
	   WebElement uploadElement= driver.findElement(By.cssSelector("input.fs-upload-input"));
	   System.out.println(System.getProperty("user.dir")+File.separator+"resources"+File.separator+fileToUpload);
	   uploadElement.sendKeys(System.getProperty("user.dir")+File.separator+"resources"+File.separator+fileToUpload);
	   Thread.sleep(3000);
	}
	@Then("the file gets uploaded on Formstone portal")
	public void the_file_gets_uploaded_on_formstone_portal()
	{
	    String uploadedFile=driver.findElement(By.cssSelector("span.file")).getText();
	    Assert.assertEquals(uploadedFile, fileToUpload);
	}

}
