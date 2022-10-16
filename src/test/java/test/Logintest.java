package test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import pageobject.Childpage;
import pageobject.Mainpage;
import resources.Base;

public class Logintest extends Base {

	public WebDriver driver; 
   @Test
	public void loin() throws IOException, InterruptedException {
	  
	   Logger log = LogManager.getLogger(Logintest.class.getName());
	
	driver = intialisedriver();
	
	driver.get(prop.getProperty("url"));
	
	log.info("url launched");
 
	
   
   Mainpage mainpage = new Mainpage(driver);
   
   mainpage.username().sendKeys(prop.getProperty("username"));
   log.debug("enter username");
   
   mainpage.password().sendKeys(prop.getProperty("password"));
   
   log.trace("password entered");
   
  mainpage.submit().click();
   
  log.trace("clicked submit");
  
  Thread.sleep(3000);
   
   Childpage childpage = new Childpage(driver);
		   
  Assert.assertTrue(childpage.title().isDisplayed()); 

   log.info("verify page and test passed");
   
   
   }
@AfterMethod
public void clouser() throws InterruptedException {
	Thread.sleep(3000);
	
	driver.close();
	
}





}
