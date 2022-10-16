package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.Childpage;
import pageobject.Mainpage;
import resources.Base;

public class log extends Base {
	public WebDriver driver;
    Mainpage mainpage;

	Childpage childpage;

	@Given("^open any browser$")
	public void open_any_browser() throws IOException, InterruptedException  {

		driver = intialisedriver();

	}

	@And("^open practice login web page$")
	public void open_practice_login_web_page()  {

		driver.get(prop.getProperty("url"));

	}

	@When("^enter username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void enter_username_something_and_password_something(String strArg1, String strArg2){

		mainpage = new Mainpage(driver);

		mainpage.username().sendKeys(prop.getProperty("username"));

		mainpage.password().sendKeys(prop.getProperty("password"));

	}

	@And("^click on submit$")
	public void click_on_submit() throws Throwable {

		mainpage.submit().click();

		Thread.sleep(3000);

	}

	@Then("^verify page child or not$")
	public void verify_page_child_or_not()  {

		childpage = new Childpage(driver);
		Assert.assertTrue(childpage.title().isDisplayed());

	}

	@After
	public void close() {

		driver.close();
	
	}

}
