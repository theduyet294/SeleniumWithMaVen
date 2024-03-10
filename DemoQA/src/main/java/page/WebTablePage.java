package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTablePage extends Page {
	public By lbInputSearch = By.id("//input[@id='searchBox]");
	public By firstName = By.xpath("//div[@role='rowgroup']/div/div[1]");
	public By lastName = By.xpath("//div[@role='rowgroup']/div/div[2]");
	public By age = By.xpath("//div[@role='rowgroup']/div/div[3]");

	public WebTablePage(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}

	public void inputSearch(String textInputSearch) {
		// click vao Type to Search
		driverWeb.findElement(By.xpath("//input[@id='searchBox']")).click();
		// Nhập input data search
		driverWeb.findElement(By.xpath("//input[@id='searchBox']")).sendKeys(textInputSearch);
		// click button search
		driverWeb.findElement(By.xpath("//div[@class='input-group-append']/span[1]//*[name()='svg']")).click();
	}

	public void clickButtonAdd() {
		// click button add
		driverWeb.findElement(By.id("addNewRecordButton")).click();
	}

	public void addAccount(String firstName, String lastName, String userEmail, String age, String salary,
			String department) {
		// click button Add

		// Input all valid data
		// First Name
		driverWeb.findElement(By.id("firstName")).sendKeys(firstName);
		// Last Name
		driverWeb.findElement(By.id("lastName")).sendKeys(lastName);
		// Email
		driverWeb.findElement(By.id("userEmail")).sendKeys(userEmail);
		// Age
		driverWeb.findElement(By.id("age")).sendKeys(age);
		// Salary
		driverWeb.findElement(By.id("salary")).sendKeys(salary);
		// Department
		driverWeb.findElement(By.id("department")).sendKeys(department);
	}

	public void clickSubmit() {
		// nhap input data
		testBase.scrollToEndPage();
		driverWeb.findElement(By.id("submit")).click();
	}

	public boolean checkSearchResult(By locator, String searchText) {
		boolean result = true;
		List<WebElement> elements = driverWeb.findElements(locator);
		
		for (WebElement e : elements) {
			String searchResultText = e.getText();
			if((searchResultText.trim() != null
					&& searchResultText.trim() != "") && (!searchResultText.contains(searchText))){
						result = false;
					}
			
				
			}
		return result;
		}
		

	}


