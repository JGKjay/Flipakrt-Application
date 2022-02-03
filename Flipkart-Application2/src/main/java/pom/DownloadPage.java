package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DownloadPage {
	private WebDriver driver;
	 
	@FindBy (xpath = "//img[@src='//static-assets-web.flixcart.com/www/linchpin/fk-cp-zion/img/Play-Store_33bb40.png']")
	private WebElement clickOnPlayStore;
	
	
	
	public DownloadPage  (WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	

	public void clickOnPlayStoreTab () throws InterruptedException {
		clickOnPlayStore.click();
		Thread.sleep(3000);
		
		
	}
	
	

}
