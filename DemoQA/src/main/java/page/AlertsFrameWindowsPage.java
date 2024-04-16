package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsFrameWindowsPage extends Page{
	public By lblBrowserWindows = By.xpath("//span[text()='Browser Windows']");
	public By lblAlerts = By.xpath("//span[text()='Alerts']");
	public By lblFrames = By.xpath("//span[text()='Frames']");
	public By lblModalDialogs = By.xpath("//span[text()='Modal Dialogs']");
	public AlertsFrameWindowsPage(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}
		public BrowserWindowsPage clickBrowserWindows() {
			testBase.clickToElement(lblBrowserWindows, timeout_short);
			return new BrowserWindowsPage(driverWeb);
		
	}

	public Page clickAlerts() {
		testBase.clickToElement(lblAlerts, timeout_short);
		return new Page(driverWeb);

	}
//	public AlertsPage clickAlerts() {
//			testBase.clickToElement(lblAlerts, timeout_short);
//			return new AlertsPage(driverWeb);
//
//	}
		public FramesPage clickFrames() {
			testBase.clickToElement(lblBrowserWindows, timeout_short);
			return new FramesPage(driverWeb);
		
	}
		public ModalDialogsPage clickModalDialogs() {
			testBase.clickToElement(lblModalDialogs, timeout_short);
			return new ModalDialogsPage(driverWeb);
		
	}

}
