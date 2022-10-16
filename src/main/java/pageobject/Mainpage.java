package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mainpage {

	WebDriver driver;

	public Mainpage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "submit")
	private WebElement submit;
	
	
	
	
	
	public WebElement username() {

		return username;
	}

	public WebElement password() {

		return password;
	}


	public WebElement submit() {

		return submit;
	}









}
