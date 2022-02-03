package test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Base;
import pom.DownloadPage;
import pom.HomePage;
import pom.LoginPage;
import pom.MorePage;



public class VerifyAppDownloadButton extends Base {
	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private SoftAssert softAssert;
	private MorePage morePage;
	private DownloadPage downloadPage;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) {

		System.out.println("launchBrowser");
		
		if(browser.equals("chrome"))
		{
			driver = openChromeBrowser();
		}
		if(browser.equals("firefox"))
		{
			driver = openFirefoxBrowser();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
}
	
	@BeforeClass
	public void initializePomClasses() {
		 loginPage =new LoginPage(driver);
		 morePage = new MorePage(driver);
         downloadPage= new DownloadPage(driver);
		 
	}
	  
   

	@BeforeMethod
    public void loginFlipkart() throws InterruptedException {
    	Thread.sleep(2000);
    	System.out.println("loginFlipkart");
    	driver.get("https://www.flipkart.com/");
        
    	loginPage.loginPage();
        softAssert = new SoftAssert();
        
    }

    //test case 1
    @Test(priority=1)
    public void toVerifyAppDownloadTab() throws InterruptedException {
    	Thread.sleep(3000);
    	System.out.println("toVerifyAppDownloadTab");
    	
    	 morePage.moveOnMorebutton();
         morePage.moveToDownloadButton();
         downloadPage.clickOnPlayStoreTab();
         System.out.println("clickOnPlayStoreTab");
    	String url =driver.getCurrentUrl();
    	System.out.println(url);
    	Assert.assertEquals(url, "https://www.flipkart.com/mobile-apps?otracker=ch_vn_mobile_apps");
    	
    	String tital = driver.getTitle();
    	softAssert.assertEquals(tital, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
    	
    	softAssert.assertAll();
    	
    	
    }
    


//     @AfterMethod
//    public void logOutFlipkart() throws InterruptedException {
//    	
//    	homePage.jayiconButton();
//    	Thread.sleep(5000);
//    	homePage.logoutButtonClick();
//    	System.out.println("logOutFlipkart");
//    	Thread.sleep(5000);
//    	
//    }
    
    @AfterClass
    public void clearObjects() {
    	loginPage =null;
		 morePage = null;
        downloadPage= null;
    	
    }
    
    @AfterTest
    public void closeBrowser() {
    	System.out.println("closeBrowser");
    	driver.quit();
    	driver = null;
    	System.gc();
    }


	
	
	
	

}
