package page;

import org.openqa.selenium.WindowType;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserWindowsPage extends Page {
	public By btnNewTab = By.id("tabButton");
	public By btnNewWindow = By.id("windowButton");
	public By btnNewWindowMessage = By.id("messageWindowButton");

	public BrowserWindowsPage(WebDriver dr) {
		super(dr);

	}

	public DemoSamplePage clickNewTab() {
		testBase.switchNewWindowByClick(btnNewTab, timeout_short);
		return new DemoSamplePage(driverWeb);

	}

	public DemoSamplePage clickNewWindow() {
		testBase.switchNewWindowByClick(btnNewWindow, timeout_short);
		return new DemoSamplePage(driverWeb);
	}

	public DemoSampleWindowAlertPage clickNewWindowMessage() {
		testBase.switchNewWindowByClick(btnNewWindowMessage, timeout_short);
		return new DemoSampleWindowAlertPage(driverWeb);
		
	}
	
	
}
