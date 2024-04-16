package test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import page.AlertsFrameWindowsPage;
import page.BrowserWindowsPage;
import page.CheckBoxPage;
import page.DemoSamplePage;
import page.DemoSampleWindowAlertPage;
import page.ElementPage;
import page.HomePage;

public class BrowserWindowsTest extends TestCase{
//	@Test
	//TC01
	public void submitNewTabSuccessfully() {
	HomePage homePage = new HomePage(testBase.driver);
	homePage.testBase.scrollToEndPage();

	AlertsFrameWindowsPage alertsFrameWindowsPage = homePage.clickAlertsFrameWindows();
	
	BrowserWindowsPage browserWindowsPage= alertsFrameWindowsPage.clickBrowserWindows();
	DemoSamplePage demoSamplePage = browserWindowsPage.clickNewTab();
	String actualHeading = demoSamplePage.testBase.getText(demoSamplePage.lbHeading, demoSamplePage.timeout_short);
	assertEquals(actualHeading, "This is a sample page");
	}
	
	//@Test
	//Tc02
	public void verifyWindow() {
		HomePage homePage = new HomePage(testBase.driver);
		homePage.testBase.scrollToEndPage();

		AlertsFrameWindowsPage alertsFrameWindowsPage = homePage.clickAlertsFrameWindows();
		
		BrowserWindowsPage browserWindowsPage= alertsFrameWindowsPage.clickBrowserWindows();
		DemoSamplePage demoSamplePage = browserWindowsPage.clickNewWindow();
		String actualHeading = demoSamplePage.testBase.getText(demoSamplePage.lbHeading, demoSamplePage.timeout_short);
		assertEquals(actualHeading, "This is sample page");
	}
	
	@Test
	//Tc03
	
	public void verifyNewWindowMessage() {
		HomePage homePage = new HomePage(testBase.driver);
		homePage.testBase.scrollToEndPage();

		AlertsFrameWindowsPage alertsFrameWindowsPage = homePage.clickAlertsFrameWindows();
		
		BrowserWindowsPage browserWindowsPage= alertsFrameWindowsPage.clickBrowserWindows();
		DemoSampleWindowAlertPage demoAlertPage = browserWindowsPage.clickNewWindowMessage();
		//String actualText = demoAlertPage.testBase.getText(demoAlertPage.lblMessage, demoAlertPage.timeout_short);
		//assertEquals(actualText, "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.");
		
	}
	
	
}