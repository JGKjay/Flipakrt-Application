package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utils.Utility;
import Utils.Utility2;
import base.Base;
import pom.HomePage;
import pom.LoginPage;



public class VerifyHomePage extends Base{
	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private SoftAssert softAssert;
	private int testID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	 
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) throws Exception {
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		System.out.println("Before Test");
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver = openChromeBrowser();
		}
		
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			driver = openFirefoxBrowser();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	  
    @BeforeMethod
    public void loginFlipkart() throws InterruptedException {
    	Thread.sleep(2000);
    	System.out.println("loginFlipkart");
    	driver.get("https://www.flipkart.com/");
        loginPage =new LoginPage(driver);
    	loginPage.loginPage();
        softAssert = new SoftAssert();
        
    }

    //test case 1
    @Test(priority=1)
    public void toVerifyTravelButtonTab() throws InterruptedException {
    	testID =101;
    	Thread.sleep(3000);
    	System.out.println("toVerifyTravelButtonTab");
    	 homePage = new HomePage(driver);
    	homePage.travelButtonClick();
    	String url =driver.getCurrentUrl();
    	System.out.println(url);
    	Assert.assertNotEquals(url, "https://www.flipkart.com/travel/flights?param=DTNavIcon&fm=neo%2Fmerchandising&iid=M_3c3ab757-b347-4446-8c57-212ccf3c6087_2_372UD5BXDFYS_MC.V4ZPKTOAO321&otracker=hp_rich_navigation_8_2.navigationCard.RICH_NAVIGATION_Travel_V4ZPKTOAO321&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_8_L0_view-all&cid=V4ZPKTOAO321");
    	
    	String tital = driver.getTitle();
    	softAssert.assertNotEquals(tital, "Flight Booking | Book Flight Tickets at Lowest Airfare on Flipkart.com");
    	
    	softAssert.assertAll();
    }
    

//test case 2
    @Test(priority=2)
    public void toVerifyMyMobiles() throws InterruptedException {
    	testID = 102;
    	Thread.sleep(3000);
    	System.out.println("toVerifyMyMobiles");
    	 
    	 homePage.mobilesNameClick();
    	String url =driver.getCurrentUrl();
    	System.out.println(url);
    	Assert.assertNotEquals(url, "https://www.flipkart.com/mobile-phones-store?fm=neo%2Fmerchandising&iid=M_86e034b3-6737-463d-ab52-4733ed7aff94_2_372UD5BXDFYS_MC.ZRQ4DKH28K8J&otracker=hp_rich_navigation_3_2.navigationCard.RICH_NAVIGATION_Mobiles_ZRQ4DKH28K8J&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_3_L0_view-all&cid=ZRQ4DKH28K8J");
    	 String tital = driver.getTitle();
    	 softAssert.assertEquals(tital, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
    	
    	 softAssert.assertAll();
    }
    
    
    
    
    @AfterMethod
    public void logOutFlipkart(ITestResult result) throws InterruptedException, IOException {
    	Thread.sleep(5000);
    	if(ITestResult.FAILURE == result.getStatus())
    	{
    	Utility2.saveScrenshot(driver, testID);
    	}
    	System.out.println("Take saveScrenshot");
    	homePage.jayiconButton();
    	Thread.sleep(5000);
    	homePage.logoutButtonClick();
    	System.out.println("logOutFlipkart");
    	Thread.sleep(5000);
    	
    }
    
    @AfterClass
    public void closeBrowser() {
    	System.out.println("closeBrowser");
    	driver.quit();
    }


	
	
	
	

}