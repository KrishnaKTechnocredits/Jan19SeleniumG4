package seleniumPractise.prachiJ.Assingment1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;
/*
 * JavaScript Prompt > Name Entered > Message under the button
 *	Validate message with name.
 */
public class AlertDemo_Q4 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		String url = "http://automationbykrishna.com/#";
		driver.get(url);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']/preceding-sibling::ul/li[4]/a")).click();
		Thread.sleep(2000);
		AlertDemo_Q4 alertDemo_Q4 = new AlertDemo_Q4();
		alertDemo_Q4.javaScriptPrompt(driver);
	}

	void javaScriptPrompt(WebDriver driver) throws InterruptedException {
		WebElement element3 = driver.findElement(By.xpath("//button[@onclick='callJavaScriptPrompt()' or @id='javascriptPromp']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element3);

		//To verify when user clicks on OK button
		element3.click();
		Thread.sleep(3000);
		Alert alert3 = driver.switchTo().alert();
		alert3.sendKeys("Prachi");
		//user clicks on OK button
		alert3.accept();
		Thread.sleep(2000);
		WebElement label3 = driver.findElement(By.xpath("//p[@class='help-block'] [@id='pgraphdemo']"));
		String actualText3 = label3.getText();
		String value = "Prachi";
		if (actualText3.contains(value)) {
			System.out.println("Entered String is validated");
		} else {
			System.out.println("Entered String is not validated");
		}
		String expectedString = "Hello Prachi! How are you today?";
		String actualString = label3.getText();
		if (expectedString.equals(actualString)) {
			System.out.println("Whole message is validated");
		} else {
			System.out.println("Whole message is not validated");
		}

		// To verify when user clicks on Cancel button
		element3.click();
		Thread.sleep(3000);
		Alert alert4 = driver.switchTo().alert();
		alert4.sendKeys("Prachi");
		Thread.sleep(2000);
		// user clicks on Cancel button
		alert4.dismiss();
		Thread.sleep(2000);
		WebElement label4 = driver.findElement(By.xpath("//p[@id='pgraphdemo' and @class='help-block']"));
		String actualText = label4.getText();
		String expectedText = "User cancelled the prompt.";
		if (actualText.contains(expectedText)) {
			System.out.println("Cancel button validated");
		} else {
			System.out.println("Cancel button not validated");
		}
	}
}
