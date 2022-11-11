package stepDefinition;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilitiesSelenium.UtilitiesClass;

public class GitHUbStepDefinition {
	WebDriver driver=null;
	JavascriptExecutor js=null;
	WebDriverWait wait=null;
	Actions action=null;
	
	@Given("^Github portal is launched$")
	public void github_portal_is_launched() throws Throwable {
		driver=UtilitiesClass.LaunchBrowser(driver,"https://www.github.com");
		js=(JavascriptExecutor)driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		action=new Actions(driver);
	    
	}

	@When("^Login is successful with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void login_is_successful_with_and(String user, String password) throws Throwable {
	    driver.findElement(By.xpath("//*[contains(@data-ga-click,'Sign in')]")).click();
	    WebElement Username=driver.findElement(By.xpath("//*[normalize-space(text())='Username or email address']/following::input[1]"));
	    wait.until(ExpectedConditions.visibilityOf(Username));
		js.executeScript("arguments[0].value=arguments[1];", Username,user);
		Thread.sleep(1500);
		WebElement Password=driver.findElement(By.xpath("//*[normalize-space(text())='Password']/following::input[1]"));
		js.executeScript("arguments[0].value=arguments[1];", Password,password);
		WebElement Login=driver.findElement(By.xpath("//*[@value='Sign in']"));
		js.executeScript("arguments[0].click();", Login);
		WebElement viewProfile=driver.findElement(By.xpath("//*[@aria-label='View profile and more']"));
		wait.until(ExpectedConditions.visibilityOf(viewProfile));
		action.moveToElement(viewProfile).click(viewProfile).build().perform();
		WebElement yourRepositories=driver.findElement(By.xpath("//*[text()='Your repositories']"));
		wait.until(ExpectedConditions.visibilityOf(yourRepositories));
		yourRepositories.click();
		
		
	    
	}

	@Then("^Find the names of the repositories$")
	public void find_the_names_of_the_repositories() throws Throwable {
		int repoCount=0;
		List<WebElement> repositoryNames=driver.findElements(By.xpath("//*[@itemprop='name codeRepository']"));
		Iterator<WebElement> itr=repositoryNames.iterator();
		while(itr.hasNext())
		{
			repoCount++;
			String repoName=itr.next().getText();
			System.out.println("Repository name is: "+repoName);
		}
		driver.close();
		System.out.println("Number Of Repositories is: "+repoCount);
		//Runtime.getRuntime().exec("Taskkill /F /IM Chrome.exe");
	    
	}



}
