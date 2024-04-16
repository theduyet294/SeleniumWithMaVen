package page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PractiveFormPage extends Page {
	public By txtStudentName= By.xpath("//td[text()='Student Name']/following-sibling::td");
	public By txtStudentEmail= By.xpath("//td[text()='Student Email']/following-sibling::td");
	public By txtGender= By.xpath("//td[text()='Gender']/following-sibling::td");
	public By txtMobile= By.xpath("//td[text()='Mobile']/following-sibling::td");
	public By txtDateofBirth= By.xpath("//td[text()='Date of Birth']/following-sibling::td");
	public By txtSubjects= By.xpath("//td[text()='Subjects']/following-sibling::td");
	public By txtHobbies= By.xpath("//td[text()='Hobbies']/following-sibling::td");
	public By txtPicture= By.xpath("//td[text()='Picture']/following-sibling::td");
	public By txtAddress= By.xpath("//td[text()='Address']/following-sibling::td");
	public By txtStateandCity= By.xpath("//td[text()='State and City']/following-sibling::td");
	
	public PractiveFormPage(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}

	public void inputData(Map data) {
		driverWeb.findElement(By.id("firstName")).sendKeys(data.get("First name").toString());
		driverWeb.findElement(By.id("lastName")).sendKeys(data.get("Last name").toString());
		driverWeb.findElement(By.id("userEmail")).sendKeys(data.get("Email").toString());
		
		testBase.scrollToEndPage();// email

		String genderXpath = "//*[text()='" + data.get("Gender").toString() + "']";
		driverWeb.findElement(By.xpath(genderXpath)).click();
		driverWeb.findElement(By.id("userNumber")).sendKeys(data.get("Mobile").toString());
//		driverWeb.findElement(By.id("dateOfBirthInput")).click();
//		driverWeb.findElement(By.id("dateOfBirthInput")).clear();
////		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// driverWeb.findElement(By.id("dateOfBirthInput")).sendKeys(data.get("Date of
		// Birth(YYYY/MM/DD)").toString());

		inputDate(data.get("Date of Birth(DD MMM YYYY)").toString());
		driverWeb.findElement(By.id("subjectsInput")).sendKeys("Maths");
		driverWeb.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
		String hobbiesXpath = "//*[text()='" + data.get("Hobbies").toString() + "']";
		driverWeb.findElement(By.xpath(hobbiesXpath)).click();
		driverWeb.findElement(By.id("uploadPicture")).sendKeys(data.get("Picture").toString());
		driverWeb.findElement(By.id("currentAddress")).sendKeys(data.get("Current Address").toString());
		driverWeb.findElement(By.id("react-select-3-input")).sendKeys(data.get("State").toString());
		driverWeb.findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);
		driverWeb.findElement(By.id("react-select-4-input")).sendKeys(data.get("City").toString());
		driverWeb.findElement(By.id("react-select-4-input")).sendKeys(Keys.ENTER);

//		

	}

	/**
	 * Date of Birth(DD MMM YYYY)
	 * 
	 * @param date
	 */
	public void inputDate(String date) {
		int maxDate = 31;
		int minOfPreviousDate = 26;
		String[] dates = date.split("\\s");
		driverWeb.findElement(By.id("dateOfBirthInput")).click();
		Select year = new Select(driverWeb.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
		year.selectByVisibleText(dates[2]);

		Select month = new Select(driverWeb.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));
		month.selectByVisibleText(dates[1]);

		List<WebElement> dateInputElements = driverWeb.findElements(By.xpath("//*[text()='" + dates[0] + "']"));
		if (dateInputElements.size() > 1) {
			int convertedDate = Integer.parseInt(dates[0]);
			// Nếu date nhập vào >26 và <31 => click vào phần tử số 2
			if (minOfPreviousDate <= convertedDate && convertedDate <= maxDate) {
				dateInputElements.get(1).click();

			} else {
				dateInputElements.get(0).click();
			}
		}
		dateInputElements.get(0).click();
	}
	

	public void clickSubmit() {
		testBase.scrollToEndPage();
		// click submit
		driverWeb.findElement(By.id("submit")).click();
	}
	
	public String getTextResult(By locator) {
		String result = "";
		result = driverWeb.findElement(locator).getText();
		return result;
	}

}
