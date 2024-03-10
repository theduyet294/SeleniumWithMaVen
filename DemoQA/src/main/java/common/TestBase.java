package common;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	public WebDriver driver;
	public void openBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\driver\\chromedriver.exe");
		 driver = new ChromeDriver();
		// gõ url
		//driver.get("https://demoqa.com/");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		// max size màn hình trước
		driver.manage().window().maximize();
	}
	//Scroll to end page 
	
	public void scrollToEndPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	/**
	 * Kiểm tra element hiển thị rồi click 
	 * @param locator
	 * @param timeBySecond
	 */
	public void clickToElement(By locator, int timeBySecond) {
		WebElement e =  driver.findElement(locator);
		waitForElementDisplayed(e, timeBySecond );
		if(e.isDisplayed()) {
			e.click();
		} else {
			System.out.println("Element not found after." + timeBySecond + "seconds");
		}
	}
	/**
	 * Input text to textbox
	 * @param locator
	 * @param text
	 */
	
	public void inputText(By locator, String text, int timeBySecond) {
		WebElement e =  driver.findElement(locator);
		waitForElementDisplayed(e, timeBySecond );
		if(e.isDisplayed()) {
			e.sendKeys(text);
		} else {
			System.out.println("Element not found after." + timeBySecond + "seconds");
		}
	}
	
	// room nhỏ màn hình
	public void zoomOut() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom = '80%'");
		
	}
	
	public String  getText(By locator, int timeBySecond) {
		String result = "";
		WebElement e =  driver.findElement(locator);
		waitForElementDisplayed(e, timeBySecond );
		if(e.isDisplayed()) {
			result = e.getText();
		} else {
			System.out.println("Element not found after." + timeBySecond + "seconds");
		}
	
		return result;
	}
	
	public void switchNewWindowByClick(By locator, int timeBySecond) {
		String originalWindow = driver.getWindowHandle();
		clickToElement(locator, timeBySecond);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeBySecond));
		for (String windowHandle : driver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
	}
	
	
	public String getValueOfAttribute(By locator, String attributeName) {
		String result="";
		result = driver.findElement(locator).getAttribute(attributeName);
		return result;
	}
	/**
	 * wait for element displayed 
	 * @param timeBySecond
	 */
	
	public void  waitForElementDisplayed(WebElement element, int timeBySecond) {
		
		   Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		   wait.until(d -> element.isDisplayed());

	}
	
	
	
	
	
	
}
