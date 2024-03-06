package CommonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	public WebDriver dc;
	
	  PropertyFileUtil putil = new PropertyFileUtil();
	  WebDriverUtil wutil = new WebDriverUtil();

	@BeforeSuite
	public void BS() {
		
	System.out.println("Connect to Data Base");
		
	}
	
    @BeforeClass
    public void BC() throws IOException {
    	
       //@BeforeClass is used to launch application
        String Browser = putil.getDataFromPropertyFile("Browser");
        String url = putil.getDataFromPropertyFile("Url");
        
        if(Browser.equals("Chrome")) {
        	ChromeDriver dc = new ChromeDriver();
        }else if(Browser.equals("Edge")) {
        	EdgeDriver dc = new EdgeDriver();
        }else {
        	FirefoxDriver dc = new FirefoxDriver();
        }
        
       //ChromeDriver dc = new ChromeDriver();
  	   //wutil.maximize(dc);
  	   //wutil.implicitWait(dc);
    }
    
    @BeforeMethod
	public void BM() throws IOException {
    	
		//@BeforeMethod is used to Login to the application
    	String Username = putil.getDataFromPropertyFile("Username");
	    String Password = putil.getDataFromPropertyFile("Password");
	    
	    dc.findElement(By.name("user_name")).sendKeys(Username);
	    dc.findElement(By.name("user_password")).sendKeys(Password);
	    dc.findElement(By.id("submitButton")).click();
	   
	}
    
    @AfterMethod
    	//@AfterMethod is used to signout from the application 
    	public void Amethod() throws InterruptedException {
    	Thread.sleep(2000);
    	//mousehover on image
    	 WebElement image = dc.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
  	     wutil.mouseover(dc, image);
  	     dc.findElement(By.xpath("//a[text()='Sign Out']")).click();
    	
    }
    
    @AfterClass
    public void AC() {
    	
    	//@AfterClass is used to close the browser
    	dc.quit();
    	
    }
    
    @AfterSuite
    public void AS(){
		System.out.println("Disconnect from data base");

    }
}


