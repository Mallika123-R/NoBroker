package Project_script;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;

import Keywords.Application_key;

public class BaseeTest {
	
	public Application_key app;
	
	@BeforeMethod
	public void Beforemethod() throws IOException
	{
		System.out.println("---start Before Method----");
		app=new Application_key();
		app.Openbrowser("Edge");
		app.driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		app.navigate("url");
	}
	

}
