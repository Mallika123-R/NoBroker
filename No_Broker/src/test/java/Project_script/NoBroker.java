package Project_script;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class NoBroker extends BaseeTest{

	@Test
	public void RentProperty() throws InterruptedException
	
	{   
		app.click("Rent_id");
		app.click("selectcity_xpath");
		app.click("city_xpath");
		app.autosuggestion("Search_css", "type_in_search");
		Thread.sleep(1500);
		app.click("serachButton_id");
		app.waitForPageToLoad();
		app.click("BHK_name");
		app.waitForPageToLoad();
       app.frame("chatframe_xpath","chat_xpath");
        Thread.sleep(1000);
        //app.frame_popup("popup_xpath");
		app.scrolled();
		app.click("ThirdProperty_xpath");
		app.waitForPageToLoad();
		app.windowhandle();
		app.type("phoneNo_id","ContactNo");
		app.waitForPageToLoad();
		app.click("radio_css");
		app.type("password_css","password");
		app.click("buttonCont_xpath");
		app.waitForPageToLoad();
		app.click("checkbox_xpath");
		app.click("Report_css");
		app.waitForPageToLoad();
		app.frame("chatframe_xpath","chat_xpath");
		app.dropdown_BHK("changeBHK_xpath");
		app.feedback("verification_xpath");
	    app.click("buttonChange_xpath");
	    
		
		
	}
	
	
}
