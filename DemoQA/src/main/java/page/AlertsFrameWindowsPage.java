package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsFrameWindowsPage extends Page{
	public By lblBrowserWindows = By.xpath("//span[text()='Browser Windows']");
	public AlertsFrameWindowsPage(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}
		public BrowserWindowsPage clickBrowserWindows() {
			testBase.clickToElement(lblBrowserWindows, timeout_short);
			return new BrowserWindowsPage(driverWeb);
		
	}

}
