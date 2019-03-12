package seleniumPractise.pallavi;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class JavaScript_Confirmation {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(1000);
		WebElement ele = driver.findElement(By.xpath(".//header[text()=' Different Examples of Alerts ']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
		String acceptMessage = "You pressed OK!";
		String dismissMessage = "You pressed Cancel!";
		WebElement element = driver.findElement(By.xpath(".//button[text()='Javascript Confirmation']"));
		element.click();
		Thread.sleep(1000);
		Alert al = driver.switchTo().alert();
		Thread.sleep(1000);
		al.accept();
		if (driver.findElement(By.id("pgraphdemo")).getText().equals(acceptMessage)) 
		{
			System.out.println("Message displayed after clicking on OK : " + acceptMessage);

		}
		Thread.sleep(1000);
		element.click();
		Thread.sleep(1000);
		Alert al1 = driver.switchTo().alert();
		Thread.sleep(1000);
		al1.dismiss();
		if (driver.findElement(By.xpath(".//*[@id='pgraphdemo']")).getText().equals(dismissMessage)) 
		{
			System.out.println("Message displayed after clicking on Cancel : " + dismissMessage);
		}
	}
}
