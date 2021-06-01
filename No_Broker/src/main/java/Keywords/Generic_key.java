package Keywords;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Generic_key {
  
	public WebDriver driver;
	public Properties prop;
	
	@Test
	public void Openbrowser(String browserName)
	{
		if(browserName.equals("Mozilla"))
		{
			System.out.println("browser name is: "+browserName);
			String pathMozilla=System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", pathMozilla);
			
			driver=new FirefoxDriver();
			
		}
		else if(browserName.equals("Edge"))
		{
			System.out.println("browser name is: "+browserName);
			//log("browser is opening" +browserName);
			String pathEdge=System.getProperty("user.dir")+"\\Drivers\\msedgedriver.exe";
			System.setProperty("webdriver.edge.driver",pathEdge);
			 
			EdgeOptions ed=new EdgeOptions();
			ed.addArguments("disable-notifications");
			ed.addArguments("Start-maximized");
			ed.addArguments("ignore-certificate-error");
			
			driver=new EdgeDriver(ed);
		}
		
	}
	
	public void navigate(String urlKey)
	{
		driver.get(prop.getProperty(urlKey));
	}
	public void click(String locatorKey)
	{
		getElement(locatorKey).click();
	}
	public void type(String locatorKey, String data)
	{
		getElement(locatorKey).sendKeys(prop.getProperty(data));
	}
	
	public void clear(String locatorKey)
	{
		getElement(locatorKey).clear();
	}
	
	
	public WebElement getElement(String locatorKey)
	{
		//check presence
		if(!isElementPresent(locatorKey))
		{
			System.out.println("Element is not present");
		}
		//check visibility
		
		if(!isElementVisible(locatorKey))
		{
			System.out.println("Element is not visible");
		}
		WebElement e=driver.findElement(getLocator(locatorKey));
		return e;
	}
	public By getLocator(String locatorKey)
	{
		By by=null;
		if(locatorKey.endsWith("_id"))
		{
			by=By.id(prop.getProperty(locatorKey));
		}
		if(locatorKey.endsWith("_css"))
		{
			by=By.cssSelector(prop.getProperty(locatorKey));
		}
		if(locatorKey.endsWith("_xpath"))
		{
			by=By.xpath(prop.getProperty(locatorKey));
		}
		if(locatorKey.endsWith("_name"))
		{
			by=By.name(prop.getProperty(locatorKey));
		}
		return by;
	}
	
	public boolean isElementVisible(String locatorKey)
	{
		System.out.println("check visibility of locator--"+locatorKey);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(locatorKey)));
		}catch(Exception e)
		{
			return false;
		}
		return true;
	}
	public boolean isElementPresent(String locatorKey)
	{
		System.out.println("check presence of locator--"+locatorKey);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		try{
			wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
		}catch(Exception e)
		{
			return false;
		}
		return true;
	}
	
	public void waitForPageToLoad() throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int i=0;
		
		while(i!=10){
		String state = (String)js.executeScript("return document.readyState;");
		System.out.println(state);

		if(state.equals("complete"))
			break;
		else
			wait(3);

		i++;
		}
		
		
		}
}
