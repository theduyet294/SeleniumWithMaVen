package page;
import common.Configuration;

import org.openqa.selenium.WebDriver;

import common.TestBase;


public class Page {
	// khởi tạo biến toàn cục trong class P age
	public WebDriver driverWeb;
	//Kế thừa Has-a đến class Test Base
	public TestBase testBase = new TestBase();
	
	public Configuration config = new Configuration(System.getProperty("user.dir") + "\\src\\main\\resources\\"+"Configurations.properties");
	public  int timeout_short = Integer.parseInt(config.getConfigValueByKey("timeout_short"));
	
	public HomePage homePage = new HomePage(driverWeb);
	
	public AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage(driverWeb);
	
	public AlertsPage alertsPPage = new AlertsPage(driverWeb);
	
	public void goToAlertPages() {
		testBase.scrollToEndPage();
		homePage.clickAlertsFrameWindows();
		alertsFrameWindowsPage.clickAlerts();
		testBase.scrollToEndPage();
	}
	// khởi tạo hàm contrutor
	public Page(WebDriver dr) {
		testBase.driver = dr;
		this.driverWeb = testBase.driver;
		
	}
	
}
