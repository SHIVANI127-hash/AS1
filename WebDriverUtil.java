package CommonUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtil {

	public WebDriver dc;
	  
	  public void maximize(WebDriver dc) {
	    dc.manage().window().maximize();
	  }
	  
	  public void implicitWait(WebDriver dc) {   
	    dc.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  }
	  public void handeldropdown(WebElement element, String targetedelement) {
		  Select s = new Select(element);
		  s.selectByVisibleText(targetedelement);
	  }
	  
	      public void mouseover(WebDriver dc, WebElement element) {
		  Actions a = new Actions(dc);
		  a.moveToElement(element);
		  a.perform();
	      }
	      
		  public void switchwindow (WebDriver Dc, String expectedurl) {
          Set<String> ids = dc.getWindowHandles();		  
		  for(String e: ids) {
		  String actualurl = dc.switchTo().window(e).getCurrentUrl();
			
			  if(actualurl.contains(expectedurl)) {
		      break;
				  
			  }
		  }
		  
		  
	  }
		  public File screenshot (WebDriver driver, String ScreenshotName) throws IOException {
			  TakesScreenshot ts = (TakesScreenshot) driver;
			  File tempfile = ts.getScreenshotAs(OutputType.FILE);
			  File destinationFile = new File("/Screenshot/\"+ScreenshotName+\".png");
			  FileUtils.copyFile(tempfile, destinationFile );
			  return destinationFile ;
		  }

}


