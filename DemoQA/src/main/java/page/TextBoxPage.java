package page;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage extends Page {
	public By txtFullName = By.id("userName");
	public By txtEmail = By.id("userEmail");
	public By txtCurrentAddress = By.id("currentAddress");
	public By txtPermanentAddress = By.id("permanentAddress");
	
	
	public By lbName = By.id("name");
	public By lbEmail = By.id("email");
	public By lbcrAddress = By.xpath("//p[@id='currentAddress']");
	public By lbperAddress = By.xpath("//p[@id='permanentAddress']");
	

	public TextBoxPage(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}
	public void inputData(String userName, String userEmail, String currentAddress, String permanentAddress ) {
		testBase.inputText(txtFullName, userName, timeout_short);
		testBase.inputText(txtEmail, userEmail, timeout_short);
		testBase.inputText(txtCurrentAddress, currentAddress, timeout_short);
		testBase.inputText(txtPermanentAddress, permanentAddress, timeout_short);
		
		
	}
	
	public void clickSubmit() {
		//nhap input data
		testBase.scrollToEndPage();
		driverWeb.findElement(By.id("submit")).click();
	}
	
	public String getActualText(By locator) { 
		String result = "";
		String originText = driverWeb.findElement(locator).getText();
		// cắt chuỗi từ phải đến dấu ':'
		int index = originText.indexOf(":");
		result = originText.substring(index + 1);
		return result;
	}
	
	
	
}
