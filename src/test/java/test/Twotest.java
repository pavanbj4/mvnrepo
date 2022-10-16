package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class Twotest extends Base{

@Test 
	public void testtwo() throws IOException, InterruptedException {
		 
		WebDriver driver = intialisedriver();
		
	
		driver.get("http://omayo.blogspot.com/");
	}
	
	
   

@AfterMethod
public void clouser() {
	
	driver.close();
	
}
}
