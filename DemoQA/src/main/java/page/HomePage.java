package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page{
	public By lblElement = By.xpath("//h5[text()='Elements']");
	public By lblForm = By.xpath("//h5[text()='Forms']");
	public By lblAlertsFrameWindows = By.xpath("//div[@class='card-body']/h5[text()='Alerts, Frame & Windows']");

	//hàm contructor do kế thừa Class Page có hàm khởi tạo
	public HomePage(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}
	
	//click vào Element
	public ElementPage clickElement() {
		//driverWeb.findElement(lblElement).click();
		
		testBase.clickToElement(lblElement, timeout_short);
		return new ElementPage(driverWeb);
	}
	public FormPage clickForm() {
		testBase.clickToElement(lblForm, timeout_short);
		return new FormPage(driverWeb);
	}
	public AlertsFrameWindowsPage clickAlertsFrameWindows() {
		testBase.clickToElement(lblAlertsFrameWindows, timeout_short);
		return new AlertsFrameWindowsPage(driverWeb);
	}
	

}