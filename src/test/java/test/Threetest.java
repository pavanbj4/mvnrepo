package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class Threetest extends Base {

	public WebDriver driver;

	@Test
	public void three() throws IOException, InterruptedException {

		driver = intialisedriver();

		driver.get("http://omayo.blogspot.com/");

		Assert.assertTrue(false);

	}

@AfterMethod
public void clouser() {
	
	driver.close();
	
}






}
