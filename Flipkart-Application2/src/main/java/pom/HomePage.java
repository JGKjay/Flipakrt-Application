package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

private WebDriver driver;
	
	@FindBy (xpath = "(//div[@class='exehdJ'])[1]")
	private WebElement jayicon;
	
	@FindBy (xpath = "//img[@alt='Travel']")
	private WebElement travel;
	
	@FindBy (xpath = "//div[text()='Mobiles']")
	private WebElement mobiles;
	
	@FindBy (xpath = "//div[text()='Logout']")
	private WebElement logout;
	
	
	public HomePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void jayiconButton() throws InterruptedException {
		Actions act = new Actions(driver);
		
		act.moveToElement(jayicon).build().perform();
		Thread.sleep(3000);
		
	}
	
	public void travelButtonClick() throws InterruptedException {
		travel.click();
		Thread.sleep(3000);
		
		}
	
	public void mobilesNameClick() {
		
		mobiles.click();
		
	}
	
    public void logoutButtonClick() throws InterruptedException {
    	
		
		Actions act = new Actions(driver);
		Thread.sleep(3000);
		act.moveToElement(logout).click().build().perform();
	
	
}
    }