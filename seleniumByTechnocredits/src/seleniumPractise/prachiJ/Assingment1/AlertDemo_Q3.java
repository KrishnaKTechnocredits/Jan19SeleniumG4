package seleniumPractise.prachiJ.Assingment1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;
/*
 * javaScript Confirmation> Ok/Cancel > Message under the button
 *	Validate the message with OK/Cancel.
 */
public class AlertDemo_Q3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		String url = "http://automationbykrishna.com/#";
		driver.get(url);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='nav navbar-nav navbar-right']/preceding-sibling::ul/li[4]/a")).click();
		Thread.sleep(2000);
		AlertDemo_Q3 alertDemo_Q3 = new AlertDemo_Q3();
		alertDemo_Q3.javascriptConfirmation(driver);
	}

	void javascriptConfirmation(WebDriver driver) throws InterruptedException {
		WebElement element2 = driver.findElement(By.xpath("//button[contains(@onclick, 'ConfirmBox()')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element2);
		element2.click();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();

		WebElement label1 = driver.findElement(
				By.xpath("//div[@id='firstRow']/following-sibling::div[1]/descendant::div[2]/following::p"));
		String actualText1 = label1.getText();
		String expectedText1 = "You pressed OK!";
		if (expectedText1.equals(actualText1)) {
			System.out.println("Success!... U pressed OK");
		} else {
			System.out.println("Failed!...... U pressed OK");
		}

		element2.click();
		Thread.sleep(2000);
		Alert alert2 = driver.switchTo().alert();
		alert2.dismiss();
		WebElement label2 = driver.findElement(By.xpath("//*[text()=' Form Elements ']/ancestor::div[2]/preceding-sibling::div[3]/descendant::div[2]/following::P"));
		String actualText2 = label2.getText();
		String expectedText2 = "You pressed Cancel!";
		if (expectedText2.equals(actualText2)) {
			System.out.println("Success!... U pressed Cancel");
		} else {
			System.out.println("Failed!...... U pressed Cancel");
		}
		Thread.sleep(2000);
	}

}
