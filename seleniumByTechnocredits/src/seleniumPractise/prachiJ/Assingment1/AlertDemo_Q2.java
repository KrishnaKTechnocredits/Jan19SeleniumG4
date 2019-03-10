package seleniumPractise.prachiJ.Assingment1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;
/*
 * Alert > Ok
 *	Validate the string of Alert with hardcoded value.
 */
public class AlertDemo_Q2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		String url = "http://automationbykrishna.com/#";
		driver.get(url);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='nav navbar-nav navbar-right']/preceding-sibling::ul/li[4]/a")).click();
		Thread.sleep(2000);
		AlertDemo_Q2 alertDemo_Q2 = new AlertDemo_Q2();
		alertDemo_Q2.alert(driver);
	}

	void alert(WebDriver driver) throws InterruptedException {
		WebElement element1 = driver.findElement(By.xpath("//button[contains(@onclick, 'ScriptAlert')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element1);
		element1.click();
		Alert alert = driver.switchTo().alert();
		String expectedText = "You must be TechnoCredits student!!";
		String actualText = alert.getText();
		System.out.println(actualText);
		alert.accept();
		if (expectedText.equals(actualText)) {
			System.out.println("Success!");
		} else {
			System.out.println("Failed!");
		}
		Thread.sleep(2000);
	}
}
