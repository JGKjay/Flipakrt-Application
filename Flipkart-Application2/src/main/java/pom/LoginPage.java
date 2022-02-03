package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Utility;

public class LoginPage {
	
	private WebDriver driver;
	
	@FindBy (xpath = "(//input[@type='text'])[2]")
	private WebElement userName;
	
	@FindBy (xpath =" //input[@type='password']")
	private WebElement passward;
	
	@FindBy (xpath = " (//button[@type='submit'])[2]")
	private WebElement logInButton;
	
	public LoginPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void loginPage () {
		
//		String userid = Utility.getStringFromSheet(1,0);
//		String pass = Utility.getStringFromSheet(1,1);
		userName.sendKeys("9096986556");
		passward.sendKeys("@Jay9096986556");
		logInButton.click();
		
		
	}

	
	

}