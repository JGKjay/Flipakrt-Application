package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MorePage {
	
 private WebDriver driver;
	
	@FindBy (xpath = "(//div[@class='exehdJ'])[2]")
	private WebElement moreButton;
	
	@FindBy (xpath = "//div[text()='Download App']")
	private WebElement downloadAppButton;
	
	public MorePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	

	public void moveOnMorebutton () throws InterruptedException {
       Actions act = new Actions(driver);
		
		act.moveToElement(moreButton).build().perform();
		Thread.sleep(3000);
		
		
	}
	
	public void moveToDownloadButton () throws InterruptedException {
     Actions act = new Actions(driver);
		
		act.moveToElement(downloadAppButton).click().build().perform();
		Thread.sleep(3000);
		
	}
	
	

}