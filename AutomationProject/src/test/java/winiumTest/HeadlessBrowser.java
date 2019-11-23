package winiumTest;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class HeadlessBrowser {

	@Test
	public void HeadlessBrowserTest() {
		WebDriver driver=new HtmlUnitDriver(true);
		driver.get("https://www.google.com");
		String Title=driver.getTitle();
		System.out.println("Browser Title is "+Title);
		Assert.assertTrue(Title.equals("Google"));
		

	}

}
